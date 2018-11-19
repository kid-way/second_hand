 package com.secondhand.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.runners.Parameterized.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.secondhand.user.entity.Orders;
import com.secondhand.user.entity.Product;
import com.secondhand.user.entity.Receiver;
import com.secondhand.user.entity.Seller;
import com.secondhand.user.entity.SmOrder;
import com.secondhand.user.entity.User;
import com.secondhand.user.exception.ProductStockException;
import com.secondhand.user.service.OrderService;

@Controller
public class OrderController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private OrderService orderService;

	@RequestMapping(value="/tijiao",method=RequestMethod.POST)
	public String tijiao(Receiver receiver,String[] iid,HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("user");
		Integer uid = user.getUid();
		try {
			Orders order = orderService.tijiao(iid, uid,receiver);
			request.setAttribute("order", order);
			return "order/zhifu";
		} catch (ProductStockException e) {
			request.setAttribute("message", e.getMessage());
			return "forward:/buycar";
		}
	}
	
	@RequestMapping(value="/{state}/{oid}/changeOrderState")
	public String cancelOrder(@PathVariable("state")Integer state,@PathVariable("oid")String oid){
		orderService.cancelOrder(oid,state); 
		return "redirect:/index";
	}
	
	@RequestMapping(value="/findOrders")
	public String findOrders(HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("user");
		if(user == null){
			return "redirect:/login";
		}else{
			List<Orders> list = orderService.findAllOrdersByUid(user.getUid());
			request.setAttribute("state", 5);
			request.setAttribute("orderList", list);
			return "order/list";
		}
	}
	
	@RequestMapping(value="/{state}/findOrdersByState")
	public String findOrdersByState(@PathVariable("state")Integer state,HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("user");
		Integer uid = user.getUid();
		List<Orders> list = orderService.findOrdersByState(uid,state);
		request.setAttribute("state", state);
		request.setAttribute("orderList", list);
		return "order/list";
	}
	
	@RequestMapping(value="/{state}/{oid}/changeOrderStatex")
	public String changeOrderStatex(@PathVariable("state") Integer state,@PathVariable("oid") String oid,HttpServletRequest request){
		orderService.cancelOrder(oid, state);
		return "forward:/"+state+"/findOrdersByState";
	}
	
	@RequestMapping(value="/{oid}/deleteOrderByOid")
	public String deleteOrderByOid(@PathVariable("oid") String oid,HttpServletRequest request){
		orderService.deleteOrder(oid);
		return "forward:/findOrders";
	}
	
	@RequestMapping(value="/{oid}/findOrderByOid")
	public String findOrderByOid(@PathVariable("oid")String oid, HttpServletRequest request){
		Orders order = orderService.findOrderByOid(oid);
		request.setAttribute("order", order);
		return "order/detail";
	}
	
	@RequestMapping(value="/{state}/findProductsByState")
	public String findProductsByState(@PathVariable("state")Integer state,HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("user");
		if(user == null){
			return "user/jsps/login";
		}else{
			Integer uid = user.getUid();
			List<Product> list = orderService.findProductsByState(uid,state);
			request.setAttribute("list", list);
			return "product/buyedProducts";
		}
	}
	
	@RequestMapping(value="/{oid}/{soid}/confirm")
	public String confirm(@PathVariable("oid") String oid,@PathVariable("soid") String soid){
		Integer state = 3;
		orderService.confirm(soid,state);
		return "forward:/"+oid+"/findOrderByOid";
	}
	
	@RequestMapping(value="/orderManage")
	public String orderManage(HttpServletRequest request){
		Seller seller = (Seller)request.getSession().getAttribute("seller");
		if(seller == null){
			return "redirect:/login";
		}else{
			List<SmOrder> smOrderList = orderService.findSmOrdersBySid(seller.getSid());
			request.setAttribute("smOrderList", smOrderList);
			return "seller/orderlist";
		}
	}
	
	@RequestMapping(value="/{state}/orderManageState")
	public String orderManageState(HttpServletRequest request,@PathVariable("state") Integer state){
		Seller seller = (Seller)request.getSession().getAttribute("seller");
		if(seller == null){
			return "redirect:/login";
		}else{
			List<SmOrder> smOrderList = orderService.findSmOrdersByState(seller.getSid(), state);
			request.setAttribute("smOrderList", smOrderList);
			return "seller/orderlist";
		}
	}
	
	@RequestMapping(value="/{soid}/{state}/consignment")
	public String consignment(HttpServletRequest request,@PathVariable("soid") String soid,@PathVariable("state") Integer state){
		orderService.updateSmOrderState(soid,state);
		return "forward:/orderManage";
	}
}