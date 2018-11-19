package com.secondhand.user.dao;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.qos.logback.classic.Logger;

import com.secondhand.user.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class BuycarDaoTest {
	private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BuycarDao buycarDao;
	
	
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testCountFromBuycar(){
		int count = buycarDao.countFromBuycar(1, 34);
		logger.info("count={}",count);
	}
	
}
