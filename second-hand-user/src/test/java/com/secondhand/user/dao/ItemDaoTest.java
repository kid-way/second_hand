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

import com.secondhand.user.entity.Item;
import com.secondhand.user.util.TransformUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ItemDaoTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ItemDao itemDao;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindItemsByUid() {
		List<Item> items = itemDao.findItemsByUid(1);
		logger.info("items={}",items);
	}
	
	@Test
	public void testDeleteItems(){
		String[] in = {"5","6"};
		itemDao.deleteItems(in);
	}
	
	@Test
	public void testFindItemsByIids(){
		String[] in = {"18","19","20"};
		List<Item> items = itemDao.findItemsByIids(in);
		for(Item item:items){
			logger.info("item={}",item);
		}
	}
	
	@Test
	public void testTotal(){
		String[] in = {"18","19","20"};
		double total = itemDao.total(in);
		logger.info("total={}",total);
	}
}
