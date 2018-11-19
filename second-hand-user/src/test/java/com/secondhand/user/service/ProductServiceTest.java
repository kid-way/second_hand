package com.secondhand.user.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.secondhand.user.dto.ProductDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
		"classpath:spring/spring-service.xml"})
public class ProductServiceTest {
	@Autowired
	private ProductService productService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindProductsByScid() {
		ProductDto productDto = productService.findProductsByScid(7, 0, 10);
		logger.info("productDto={}",productDto);
	}
	
	@Test
	public void testNameLikeProducts(){
		ProductDto productDto = productService.findProductsLikePname("机", 10, 10);
		logger.info("productDto={}",productDto);
	}
}
