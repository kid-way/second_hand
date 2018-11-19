package com.secondhand.user.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.secondhand.user.entity.Orders;
import com.secondhand.user.exception.ProductStockException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
		"classpath:spring/spring-service.xml"})
public class OrderServiceTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderService orderService;
	
	@Test
	public void testTijiao() {
		String[] in = {"04c6e2371e1d4545b21d3cfdcde0c3ff","f5c03777e8e64a8789adaf46fb8d2a79"};
		try{
			orderService.tijiao(in, 9, null);
		}catch (ProductStockException e) {
			logger.info("message:{}",e.getMessage());
		}
	}
}
