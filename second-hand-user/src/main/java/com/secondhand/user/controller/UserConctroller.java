package com.secondhand.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.secondhand.user.entity.Seller;
import com.secondhand.user.entity.User;
import com.secondhand.user.exception.LoginException;
import com.secondhand.user.exception.RegistException;
import com.secondhand.user.exception.UpdateException;
import com.secondhand.user.service.UserService;

/**
 * 购买者controller
 * @author kid_way
 *
 */
@Controller
public class UserConctroller {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserService userService;
	
	//前往购买者登录页面
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "user/jsps/login";
	}
	
	//验证购买者表单信息，验证通过前往主页，验证不通过则返回登录页面
	@RequestMapping(value="/toLogin",method=RequestMethod.POST) 
	public String toLogin(String username,String password,HttpServletRequest request){
		if(username==null||username==""){
			request.setAttribute("msg", "用户名不能为空！");
			return "user/jsps/login";
		}else if(password==null||password==""){
			request.setAttribute("msg", "密码不能为空！");
			return "user/jsps/login";
		}else{
			try{
				User user = userService.login(username, password);
				request.getSession().setAttribute("user", user);
			}catch(LoginException e){ 
				request.setAttribute("msg", e.getMessage());
				return "user/jsps/login";
			}
			return "redirect:/index";
		}
	}
	
	//前往购买者注册页面
	@RequestMapping(value="/regist")
	public String regist(){
		return "user/jsps/regist";
	}
	
	//验证购买者注册表单信息，验证通过则前往登录页面，否则重返注册页面
	@RequestMapping(value="/toRegist",method=RequestMethod.POST)
	public String toRegist(User user,HttpServletRequest request){
		if(user.getUsername()==null||user.getUsername().trim()==""){
			request.setAttribute("msg", "用户名不能为空");
			return "user/jsps/regist";
		}
		if(user.getAge()==null||user.getAge()<=0||user.getAge()>120){
			request.setAttribute("msg", "年龄超出范围了");
			return "user/jsps/regist";
		}
		if(user.getUphone().length()!=11){
			request.setAttribute("msg", "手机号必须11位");
			return "user/jsps/regist";
		}if(user.getPassword()==null||user.getPassword().trim()==""){
			request.setAttribute("msg", "密码不能为空");
			return "user/jsps/regist";
		}else{
			try{
				userService.regist(user);
				return "user/jsps/login";
			}catch(RegistException e){
				request.setAttribute("msg", e.getMessage());
				return "user/jsps/regist";
			}
		}
	}
	
	//注销购买者信息，退出登录
	@RequestMapping(value="/quit")
	public String quit(HttpServletRequest request){
		request.getSession().removeAttribute("user");
		return "redirect:/index";
	}
	
	//前往修改购买者个人信息页面
	@RequestMapping(value="/toUpdateUser")
	public String toUpdateUser(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		request.getSession().setAttribute("user", user);
		request.setAttribute("user", user);
		return "user/jsps/detail";
	}
	
	//验证提交的修改表单
	@RequestMapping(value="/{uid}/updateUser")
	public String updateUser(@PathVariable("uid")Integer uid,User user,HttpServletRequest request){
		User sessionUser = (User)request.getSession().getAttribute("user");
		if(user.getUsername()==null||user.getUsername().trim()==""){
			request.setAttribute("msg", "用户名不能为空");
			return "user/jsps/detail";
		}
		if(user.getAge()==null||user.getAge()<=0||user.getAge()>120){
			request.setAttribute("msg", "年龄超出范围了");
			return "user/jsps/detail";
		}
		if(user.getUphone().length()!=11){
			request.setAttribute("msg", "手机号必须11位");
			return "user/jsps/detail";
		}if(user.getPassword()==null||user.getPassword().trim()==""){
			request.setAttribute("msg", "密码不能为空");
			return "user/jsps/detail";
		}else{
			try{
				user.setUid(uid);
				User sqlUser = userService.update(user,sessionUser);
				request.getSession().setAttribute("user", sqlUser);
				return "redirect:/index";
			}catch(UpdateException e){
				request.setAttribute("msg", e.getMessage());
				return "user/jsps/detail";
			}
		}
	}
}
