package com.secondhand.user.dao;

import com.secondhand.user.entity.Seller;

/**
 * <p>Title: SellerDao</p>
*<p>Description: 卖家dao</p>
*@author kid_way
*@date 2018-1-8 下午10:41:49
 */
public interface SellerDao {
	
	/**
	 * 根据卖家名称查找卖家
	 * @param sname 
	 * @return
	 */
	public Seller findSellerBySname(String sname);
	
	/**
	 * 根据卖家手机查询卖家信息
	 * @param sphone
	 * @return
	 */
	public Seller findSellerBySphone(String sphone);
	
	/**
	 *添加卖家 
	 * @param seller
	 */
	public void addSeller(Seller seller);
	
	/**
	 * 通过卖家主键查找卖家对象
	 * @param sid
	 * @return
	 */
	public Seller findSellerBySid(Integer sid);

	/**
	 * 更新用户信息
	 * @param seller
	 */
	public void update(Seller seller);
}
