package com.secondhand.user.service;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.secondhand.user.entity.Seller;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
						"classpath:spring/spring-service.xml"})
public class SellerServiceTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SellerService sellerService;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLogin() {
		String sname = "陈真";
		String password = "1233333";
		Seller seller = sellerService.login(sname, password);
		logger.info("seller={}",seller);
	}

	@Test
	public void testRegist() {
		Seller seller = new Seller();
		seller.setAddress("广东省深圳市宝安区");
		seller.setAge(18);
		seller.setGender(0);
		seller.setPassword("yyyaaa222");
		seller.setSname("小木");
		seller.setSphone("118828828");
		sellerService.regist(seller);
	}
	
}
