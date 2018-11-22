package com.secondhand.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.secondhand.user.dto.ProductDto;
import com.secondhand.user.entity.Seller;
import com.secondhand.user.entity.User;
import com.secondhand.user.exception.LoginException;
import com.secondhand.user.exception.RegistException;
import com.secondhand.user.exception.UpdateException;
import com.secondhand.user.service.ProductService;
import com.secondhand.user.service.SellerService;

/**
 * 卖家controller
 * @author kid_way
 *
 */
@Controller
@RequestMapping(value="/seller")
public class SellerController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private ProductService productService;
	
	//前往卖家登录页面
	@RequestMapping(value="/login")
	public String login(){
		return "seller/login";
	}

	//验证卖家登录信息，验证通过则前往卖家的闲置首页，否则返回登录页面
	@RequestMapping(value="/toLogin")
	public String toLogin(String sname,String password,HttpServletRequest request){
		if(sname==null||sname.trim()==""){
			request.setAttribute("msg", "名称不能为空");
			return "seller/login";
		}else if(password==null||password.trim()==""){
			request.setAttribute("msg", "密码不能为空");
			return "seller/login";
		}
		try{
			Seller seller = sellerService.login(sname, password);
			request.getSession().setAttribute("seller", seller);
			return "redirect:1/sellerindex";
		}catch(LoginException e){
			request.setAttribute("msg", e.getMessage());
			return "seller/login";
		}
	}
	
	//前往注册页面
	@RequestMapping(value="/regist")
	public String regist(){
		return "seller/regist";
	}
	
	//验证卖家注册信息，注册通过则前往登录页面，否则返回注册页面
	@RequestMapping(value="/toRegist",method=RequestMethod.POST)
	public String toRegist(Seller seller,HttpServletRequest request){
		if(seller.getSname()==null||seller.getSname().trim()==""){
			request.setAttribute("msg", "卖家名不能为空");
			return "seller/regist";
		}
		if(seller.getAge()<=0||seller.getAge()>120){
			request.setAttribute("msg", "年龄超出范围了");
			return "seller/regist";
		}
		if(seller.getSphone().length()!=11){
			request.setAttribute("msg", "手机号必须11位");
			return "seller/regist";
		}if(seller.getPassword()==null||seller.getPassword().trim()==""){
			request.setAttribute("msg", "密码不能为空");
			return "seller/regist";
		}else{
			try{
				sellerService.regist(seller);
				return "seller/login";
			}catch(RegistException e){
				request.setAttribute("msg", e.getMessage());
				return "seller/regist";
			}
		}
	}
	
	//前往更改卖家个人信息页面
	@RequestMapping(value="/toUpdateSeller")
	public String toUpdateSeller(HttpServletRequest request){
		return "seller/update";
	}
	
	//更新卖家个人信息
	@RequestMapping(value="/update")
	public String update(Seller seller,HttpServletRequest request){
		Seller sessionSeller = (Seller)request.getSession().getAttribute("seller");
		if(seller.getSname()==null||seller.getSname().trim()==""){
			request.setAttribute("msg", "卖家名不能为空");
			return "seller/update";
		}
		if(seller.getAge()==null||seller.getAge()<=0||seller.getAge()>120){
			request.setAttribute("msg", "年龄超出范围了");
			return "seller/update";
		}
		if(seller.getSphone().length()!=11){
			request.setAttribute("msg", "手机号必须11位");
			return "seller/update";
		}
		if(seller.getAddress()==null||seller.getAddress().trim()==""){
			request.setAttribute("msg", "地址不能为空");
			return "seller/update";
		}
		if(seller.getPassword()==null||seller.getPassword().trim()==""){
			request.setAttribute("msg", "密码不能为空");
			return "seller/update";
		}else{
			try{
				seller.setSid(sessionSeller.getSid());
				Seller sqlSeller = sellerService.update(seller,sessionSeller);
				request.getSession().setAttribute("seller", sqlSeller);
				return "redirect:1/sellerindex";
			}catch(UpdateException e){
				request.setAttribute("msg", e.getMessage());
				return "seller/update";
			}
		}
	}
	
	//查询卖家的所有闲置并返回卖家首页
	@RequestMapping(value="/{page}/sellerindex")
	public String toSellerIndex(@PathVariable("page") Integer page,HttpServletRequest request){
		Seller seller = (Seller)request.getSession().getAttribute("seller");
		if(seller==null){
			return "redirect:/seller/login";
		}else{
			Integer sid = seller.getSid();
			ProductDto productDto = productService.findProductsBySid(sid,page);
			request.setAttribute("page", page);
			request.setAttribute("productDto", productDto);
			return "seller/index";
		}
	}
	
	//卖家退出登录
	@RequestMapping(value="/quit")
	public String quit(HttpServletRequest request){
		request.getSession().removeAttribute("seller");
		return "redirect:/index";
	}
}
