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

import com.secondhand.user.entity.SmOrder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SmOrderDaoTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SmOrderDao smOrderDao;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindSmOrdersBySid() {
		List<SmOrder> list = smOrderDao.findSmOrdersBySid(1);
		for(SmOrder smOrder:list){
			logger.info("smOrder={}",smOrder);
		}
	}
	
	@Test
	public void testFindSmOrdersByState(){
		List<SmOrder> list = smOrderDao.findSmOrdersByState(1, 1);
		for(SmOrder smOrder : list){
			logger.info("smOrder={}",smOrder);
		}
	}

}
