package com.secondhand.user.service;

import java.util.List;

import com.secondhand.user.entity.Orders;
import com.secondhand.user.entity.Product;
import com.secondhand.user.entity.Receiver;
import com.secondhand.user.entity.SmOrder;
import com.secondhand.user.exception.ProductStockException;

public interface OrderService {
	/**
	 * 订单提交
	 * @param iid
	 * @param uuid
	 * @param receiver
	 * @return
	 */
	public Orders tijiao(String[] iid,Integer uuid,Receiver receiver) throws ProductStockException;
	
	/**
	 * 取消订单
	 * @param oid
	 * @param state
	 */
	public void cancelOrder(String oid,Integer state);
	
	/**
	 * 通过用户id查找用户的订单列表
	 * @param uid
	 * @return
	 */
	public List<Orders> findAllOrdersByUid(Integer uid);

	/**
	 * 通过用户Id和订单状态查找订单列表
	 * @param uid
	 * @param state
	 * @return
	 */
	public List<Orders> findOrdersByState(Integer uid, Integer state);

	/**
	 * 根据订单id删除订单
	 * @param oid
	 */
	public void deleteOrder(String oid);
	
	/**
	 * 根据订单id查询订单
	 * @param oid
	 * @return
	 */
	public Orders findOrderByOid(String oid);
	
	/**
	 * 根据用户id及订单状态查询相关的商品
	 * @param uid
	 * @param state
	 * @return
	 */
	public List<Product> findProductsByState(Integer uid, Integer state);

	/**
	 * 根据小订单id和订单状态确认订单
	 * @param soid
	 * @param state
	 */
	public void confirm(String soid, Integer state);
	
	/**
	 * 订单管理查询卖家所有订单
	 * @param sid 卖家id
	 * @return
	 */
	public List<SmOrder> findSmOrdersBySid(Integer sid);
	
	/**
	 * 订单管理查询相对应状态的卖家订单
	 * @param sid
	 * @param state
	 * @return
	 */
	public List<SmOrder> findSmOrdersByState(Integer sid, Integer state);
	
	/**
	 * 订单管理发货：改变订单状态
	 * @param soid
	 * @param state
	 */
	public void updateSmOrderState(String soid, Integer state);
}	
