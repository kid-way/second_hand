package com.secondhand.user.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.secondhand.user.dao.BuycarDao;
import com.secondhand.user.dao.ItemDao;
import com.secondhand.user.dao.OrderDao;
import com.secondhand.user.dao.ProductDao;
import com.secondhand.user.dao.SellerDao;
import com.secondhand.user.dao.SmOrderDao;
import com.secondhand.user.dto.ProductStockDto;
import com.secondhand.user.entity.Item;
import com.secondhand.user.entity.Orders;
import com.secondhand.user.entity.Product;
import com.secondhand.user.entity.Receiver;
import com.secondhand.user.entity.Seller;
import com.secondhand.user.entity.SmOrder;
import com.secondhand.user.exception.ProductStockException;
import com.secondhand.user.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private SmOrderDao smOrderDao;
	
	@Autowired
	private BuycarDao buycarDao;
	
	@Autowired
	private SellerDao sellerDao;
	
	@Autowired
	private ProductDao productDao;
	
	//步骤：1.通过数组iid获得List<Item>
	//		2.new 一个Orders，往里面添加属性，oid(uuid),  new 一个ArrayList<SmOrder>,遍历List<Item>,把每个Item变成SmOrder,再将SmOrder加入List<SmOrder>
	// 		3.往数据库添加一个Orders，和批量添加SmOrder，即传入List<SmOrder>
	// 		4.批量删除已加入订单的条目
	//		5.
	@Override
	@Transactional
	public Orders tijiao(String[] iid,Integer uid,Receiver receiver) throws ProductStockException{
		List<ProductStockDto> list = itemDao.findItemProductStrock(iid);
		for(ProductStockDto productStockDto : list){
			if(productStockDto.getCount()>productStockDto.getStock()){
				throw new ProductStockException("商品："+productStockDto.getPname()+"库存不足！");
			}else{
				Integer count = productStockDto.getCount();
				Integer pid = productStockDto.getPid();
				productDao.updateStock(pid, -count);
			}
		}
		List<Item> items = itemDao.findItemsByIids(iid);
		double total = itemDao.total(iid);
		Orders order = new Orders();
		String oid = UUID.randomUUID().toString().replaceAll("-", "");		
		order.setOid(oid);
		order.setState(0);
		order.setTotal(total);
		order.setCreateTime(new Date());
		order.setRaddress(receiver.getRaddress());
		order.setRname(receiver.getRname());
		order.setRphone(receiver.getRphone());
		order.setUid(uid);
		orderDao.addOrder(order);
		Map<Seller,List<SmOrder>> map = new HashMap<Seller,List<SmOrder>>();
		List<SmOrder> smOrders = new ArrayList<SmOrder>();
		for(Item item : items){
			SmOrder smOrder = new SmOrder();
			String soid = UUID.randomUUID().toString().replaceAll("-", "");
			smOrder.setIid(item.getIid());
			smOrder.setOid(oid);
			smOrder.setSoid(soid);
			smOrder.setState(0);
			smOrder.setCreateTime(new Date());
			smOrder.setItem(item);
			smOrder.setRaddress(receiver.getRaddress());
			smOrder.setRname(receiver.getRname());
			smOrder.setRphone(receiver.getRphone());
			Integer sid = item.getProduct().getSid();
			Seller seller = sellerDao.findSellerBySid(sid);
			item.getProduct().getSeller();
			if(map.get(seller)!=null){
				List<SmOrder> smOrderList = map.get(seller);
				smOrderList.add(smOrder);
				smOrders.add(smOrder);
			}else{
				List<SmOrder> smOrderList = new ArrayList<SmOrder>();
				smOrderList.add(smOrder);
				map.put(seller, smOrderList);
				smOrders.add(smOrder);
			}
		}
		smOrderDao.addSmOrders(smOrders);
		buycarDao.delete(iid);
		order.setMap(map);
		
		return order;
	}
	
	@Transactional
	@Override
	public void cancelOrder(String oid,Integer state) {
		orderDao.changeOrderState(oid, state);//todo
		List<ProductStockDto> list = orderDao.getProductStockDto(oid);
		for(ProductStockDto productStockDto : list){
			Integer pid = productStockDto.getPid();
			Integer count = productStockDto.getCount();
			productDao.updateStock(pid, count);
		}
		smOrderDao.changeStateByOid(oid, state);
	}

	@Override
	public List<Orders> findAllOrdersByUid(Integer uid) {
		List<Orders> list = orderDao.findAllOrders(uid);
		return list;
	}

	@Override
	public List<Orders> findOrdersByState(Integer uid, Integer state) {
		List<Orders> list = orderDao.findOrdersByState(uid,state);
		return list;
	}

	@Override
	@Transactional
	public void deleteOrder(String oid) {
		orderDao.deleteOrder(oid);
		smOrderDao.deleteSmOrders(oid);
	}

	@Override
	public Orders findOrderByOid(String oid) {
		Orders order = orderDao.findOrderByOid(oid);
		Map<Seller,List<SmOrder>> map = new HashMap<Seller,List<SmOrder>>();
		List<SmOrder> list = order.getList();
		for(SmOrder smOrder : list){
			Seller seller = smOrder.getItem().getProduct().getSeller();
			if(map.get(seller)==null){
				List<SmOrder> slist = new ArrayList<SmOrder>();
				slist.add(smOrder);
				map.put(seller, slist);
			}else{
				List<SmOrder> slist = map.get(seller);
				slist.add(smOrder);
			}
		}
		order.setMap(map);
		return order;
	}

	@Override
	public List<Product> findProductsByState(Integer uid, Integer state) {
		List<Product> pList = orderDao.findProductsByState(uid,state);		
		return pList;
	}

	@Override
	@Transactional
	public void confirm(String soid, Integer state) {
		smOrderDao.changeStateBySoid(soid,state);
	}

	@Override
	public List<SmOrder> findSmOrdersBySid(Integer sid) {
		List<SmOrder> smOrderList = smOrderDao.findSmOrdersBySid(sid);
		return smOrderList;
	}

	@Override
	public List<SmOrder> findSmOrdersByState(Integer sid, Integer state) {
		List<SmOrder> smOrderList = smOrderDao.findSmOrdersByState(sid, state);
		return smOrderList;
	}

	@Override
	public void updateSmOrderState(String soid, Integer state) {
		smOrderDao.changeStateBySoid(soid, state);
	}
}
