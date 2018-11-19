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

import com.secondhand.user.entity.Orders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class OrderDaoTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderDao orderDao;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindAllOrders() {
		List<Orders> list = orderDao.findAllOrders(1);
		for(Orders order : list){
			logger.info("order={}",order);
		}
	}
	
	@Test
	public void testFindOrdersByState(){
		List<Orders> list = orderDao.findOrdersByState(1, 0);
		for(Orders order: list){
			logger.info("order={}",order);
		}
	}
	
	@Test
	public void testFindOrderByOid(){
		Orders order = orderDao.findOrderByOid("b987f53ac39c4c6a87aeca1112109c20");
		logger.info("order={}",order);
	}
}
