package com.secondhand.user.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secondhand.user.dao.FirstCategoryDao;
import com.secondhand.user.dao.SecondCategoryDao;
import com.secondhand.user.entity.FirstCategory;
import com.secondhand.user.entity.SecondCategory;
import com.secondhand.user.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FirstCategoryDao firstCategoryDao;
	
	@Autowired
	private SecondCategoryDao secondCategoryDao;
	@Override
	public List<FirstCategory> findAllCategory() {
		List<FirstCategory> list = firstCategoryDao.findAllCategory();
		return list;
	}
	@Override
	public List<SecondCategory> getSecondCategory(Integer fcid) {
		List<SecondCategory> scList = secondCategoryDao.findSecondCategorysByFcid(fcid);
		return scList;
	}

}
