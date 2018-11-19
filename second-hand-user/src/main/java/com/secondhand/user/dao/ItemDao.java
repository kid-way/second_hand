package com.secondhand.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.secondhand.user.dto.ProductStockDto;
import com.secondhand.user.entity.Item;

public interface ItemDao {
	
	/**
	 * 添加条目
	 * @param item
	 */
	public void addItem(Item item);
	
	/**
	 * 根据uid查找对应的所有条目
	 * @param uid
	 * @return List<Item> 条目列表
	 */
	public List<Item> findItemsByUid(Integer uid);

	/**
	 * 删除条目
	 * @param iid
	 */
	public void deleteItem(String iid);
	
	/**
	 * 批量删除条目
	 * @param iid
	 */
	public void deleteItems(String[] iid);
	
	/**
	 * 根据iid数组查询对应的条目列表
	 * @param in 条目id数组
	 * @return List<Item> 条目列表
	 */
	public List<Item> findItemsByIids(String[] in);
	
	/**
	 * 根据iid数组查询对应的条目列表小计只和，即总计
	 * @param in
	 * @return 
	 */
	public double total(String[] in);
	
	public List<ProductStockDto> findItemProductStrock(String[] iid);

}
