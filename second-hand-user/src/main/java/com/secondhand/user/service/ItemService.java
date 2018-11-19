package com.secondhand.user.service;

import java.util.List;

import com.secondhand.user.dto.ItemDto;
import com.secondhand.user.entity.Buycar;
import com.secondhand.user.entity.Item;

/**
 * <p>Title: ItemService</p>
*<p>Description: 条目service</p>
*@author kid_way
*@date 2018-1-15 下午8:34:01
 */
public interface ItemService {
	
	/**
	 * 添加条目
	 * @param item
	 */
	public void addItem(Item item,Buycar buycar);
	
	/**
	 * 通过用户id查找用户的条目列表
	 * @param uid
	 * @return
	 */
	public List<Item> findItemsByUid(Integer uid);

	/**
	 * 根据条目id删除条目
	 * @param iid
	 */
	public void deleteItem(String iid);
	
	/**
	 * 根据iid数组批量删除条目
	 * @param iid
	 */
	public void deleteItems(String[] iid);
	
	/**
	 * 结算页面所需数据包装
	 * @param in
	 * @return 条目包装类
	 */
	public ItemDto jiesuan(String[] in);
}
