package com.secondhand.user.dao;

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
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SellerDaoTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SellerDao sellerDao;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindSellerBySname() {
		Seller seller = sellerDao.findSellerBySname("陈真");
		logger.info("seller={}",seller);
	}

	@Test
	public void testFindSellerBySphone() {
		String sphone = "567999111";
		Seller seller = sellerDao.findSellerBySphone(sphone);
		logger.info("seller={}",seller);
	}

	@Test
	public void testAddSeller() {
		Seller seller = new Seller();
		seller.setAddress("北京市朝阳区");
		seller.setAge(20);
		seller.setGender(1);
		seller.setPassword("kkkkkksss");
		seller.setSname("嘻哈侠");
		seller.setSphone("567999111");
		sellerDao.addSeller(seller);
	}

}
