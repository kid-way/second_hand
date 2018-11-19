package com.secondhand.user.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.secondhand.user.dao.BuycarDao;
import com.secondhand.user.dao.ItemDao;
import com.secondhand.user.dto.ItemDto;
import com.secondhand.user.entity.Buycar;
import com.secondhand.user.entity.Item;
import com.secondhand.user.service.ItemService;

/**
 * <p>Title: ItemServiceImpl</p>
*<p>Description: ItemService的实现类</p>
*@author kid_way
*@date 2018-1-15 下午8:35:24
 */
@Service
public class ItemServiceImpl implements ItemService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private BuycarDao buycarDao;
	
	@Override
	@Transactional
	public void addItem(Item item,Buycar buycar) {
		itemDao.addItem(item);
		buycarDao.add(buycar);
	}
	@Override
	public List<Item> findItemsByUid(Integer uid) {
		List<Item> items = itemDao.findItemsByUid(uid);
		return items;
	}
	@Override
	@Transactional
	public void deleteItem(String iid) {
		buycarDao.deleteItem(iid);
		itemDao.deleteItem(iid);
	}
	@Override
	@Transactional
	public void deleteItems(String[] iid) {
		buycarDao.delete(iid);
		itemDao.deleteItems(iid);
	}
	@Override
	public ItemDto jiesuan(String[] iid) {
		List<Item> items = itemDao.findItemsByIids(iid);
		double total = itemDao.total(iid);
		ItemDto itemDto = new ItemDto();
		itemDto.setItems(items);
		itemDto.setTotal(total);
		return itemDto;
	}

}
