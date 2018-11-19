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

import com.secondhand.user.dto.ProductDto;
import com.secondhand.user.entity.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ProductDaoTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductDao productDao;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindProductsBySid() {
		List<Product> list = productDao.findProductsBySid(3,0,10);
		for(Product product: list){
			logger.info("product={}",product);
		}
	}

	@Test
	public void testFindAllProducts() {
		List<Product> list = productDao.findAllProducts();
		for(Product product: list){
			logger.info("product={}",product);
		}
	}

	@Test
	public void testFindProductsByFcid() {
		List<Product> list = productDao.findProductsByFcid(2);
		for(Product product: list){
			logger.info("product={}",product);
		}
	}

	@Test
	public void testFindProductsByScid() {
		ProductDto productDto = productDao.findProductsByScid(5,10,10);
		logger.info("productDto={}",productDto);
	}

	@Test
	public void testFindProductByPid() {
		Product product = productDao.findProductByPid(4);
		logger.info("product={}",product);
	}

	@Test
	public void testFindProductsLikePname() {
		List<Product> list = productDao.findProductsLikePname("魅",0,10);
		for(Product product:list){
			logger.info("product={}",product);
		}
	}

	@Test
	public void testAddProduct() {
		Product product = new Product();
		product.setApicname("shoujia5.jpg");
		product.setBpicname("shoujib6.jpg");
		product.setFcid(2);
		product.setPname("小米");
		product.setPrice(500.00);
		product.setScid(5);
		product.setSid(2);
		product.setStock(2);
		productDao.addProduct(product); 
	}

	@Test
	public void testDeleteProduct() {
		productDao.deleteProduct(3);
	}

	@Test
	public void testUpdateProduct() {
		Product product = productDao.findProductByPid(2);
		product.setStock(2);
		productDao.updateProduct(product);
	}
	@Test
	public void testScProductCount(){
		int a = productDao.scProductCount(5);
		logger.info("a={}",a);
	}
	
	@Test
	public void testNameLikeProductCount(){
		int a = productDao.nameLikeProductCount("机");
		logger.info("a={}",a);
	}
}
