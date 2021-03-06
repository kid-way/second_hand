package com.secondhand.user.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.secondhand.user.dto.ItemDto;
import com.secondhand.user.entity.Buycar;
import com.secondhand.user.entity.Item;
import com.secondhand.user.entity.Product;
import com.secondhand.user.entity.User;
import com.secondhand.user.service.ItemService;
import com.secondhand.user.service.ProductService;
import com.secondhand.user.util.TransformUtil;

/**
 * 条目conrtoller
 * @author kid_way
 *
 */
@Controller
public class ItemController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ProductService productService;
	
	//点击添加到购物车，先验证用户是否已登录，未登录返回登录页面，已登录就生成条目和购物车，将uid和条目id添加到购物车中
	@RequestMapping(value="/addToBuyCar",method=RequestMethod.POST)
	public String addToBuyCar(Integer pid,HttpServletRequest request,Integer count, Double price){
		User user = (User)request.getSession().getAttribute("user");
		if(user == null){
			return "redirect:/login";
		}else{
			double subtotal = count*price;
			Item item = new Item();
			String iid = UUID.randomUUID().toString().replace("-", "");
			item.setIid(iid);
			item.setPid(pid);
			item.setCount(count);
			item.setSubtotal(subtotal);
			Buycar buycar = new Buycar();
			buycar.setIid(iid);	
			buycar.setUid(user.getUid());
			itemService.addItem(item,buycar);
			return "redirect:/"+pid+"/detailProduct";
		}
	}
	
	//判断用户是否已登录，通过uid查询用户在购物车中添加的条目
	@RequestMapping(value="/buycar")
	public String buycar(HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("user");
		if(user==null){
			return "redirect:/login";//todo
		}else{
			Integer uid = user.getUid();
			List<Item> items = itemService.findItemsByUid(uid);
			request.setAttribute("items", items);
			return "buycar/list";
		}
	}
	
	//移除购物车中的商品
	@RequestMapping(value="/{iid}/deleteItem")
	public String deleteItem(@PathVariable("iid")String iid){
		itemService.deleteItem(iid);
		return "forward:/buycar";
	}
	
	//批量移除购物车中的商品
	@RequestMapping(value="/deleteItems",method=RequestMethod.POST)
	public String deleteItems(@RequestParam("iid")String[] iid,Model model){
			itemService.deleteItems(iid);
			return "forward:/buycar";
		}
	
	//通过条目id数组，获取条目list，并生成条目包装类
	@RequestMapping(value="/jiesuan",method=RequestMethod.POST)
	public String jiesuan(@RequestParam("iid")String[] iid,Model model){
		ItemDto itemDto = itemService.jiesuan(iid);
		model.addAttribute("itemDto",itemDto);
		return "order/jiesuan1";
	}
}
