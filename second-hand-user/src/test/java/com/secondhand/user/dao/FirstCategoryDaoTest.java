package com.secondhand.user.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.secondhand.user.entity.FirstCategory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class FirstCategoryDaoTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FirstCategoryDao firstCategoryDao;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testFindAllCategory() {
		List<FirstCategory> list = firstCategoryDao.findAllCategory();
		for(FirstCategory firstCategory:list){
			logger.info("firstCategory={}",firstCategory);
		}
	}

}
