package com.secondhand.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.secondhand.user.entity.FirstCategory;
import com.secondhand.user.entity.SecondCategory;
import com.secondhand.user.service.CategoryService;

@Controller
public class CategoryController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/index")
	public String index(Model model){
		List<FirstCategory> list = categoryService.findAllCategory();
		model.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping(value="/{fcid}/getSecondCategory",
			method = RequestMethod.POST,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<SecondCategory> getSecondCategory(@PathVariable("fcid") Integer fcid,HttpServletRequest request){
		List<SecondCategory> scList = categoryService.getSecondCategory(fcid);
		return scList;
	}
}
