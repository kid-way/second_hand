package com.secondhand.user.service;

import com.secondhand.user.entity.Seller;
import com.secondhand.user.exception.LoginException;
import com.secondhand.user.exception.RegistException;

/**
 * <p>Title: SellerService</p>
*<p>Description: 卖家service</p>
*@author kid_way
*@date 2018-1-9 上午11:42:11
 */
public interface SellerService{
	/**
	 * 卖家登录功能
	 * @param sname 卖家名称
	 * @param password 卖家密码
	 * @return Seller 卖家实体类
	 * @throws LoginException 登录异常
	 */
	public Seller login(String sname,String password) throws LoginException;
	
	/**
	 * 卖家注册功能
	 * @param seller 卖家实体类
	 * @throws RegistException 注册异常
	 */
	public void regist(Seller seller) throws RegistException;
	
	/**
	 * 根据卖家名查找卖家
	 * @param sname
	 * @return
	 */
	public Seller findBySname(String sname);

	/**
	 * 根据卖家电话查找卖家
	 * @param sphone
	 * @return
	 */
	public Seller findBySphone(String sphone);
	
	/**
	 * 更新卖家信息
	 * @param seller
	 */
	public Seller update(Seller seller,Seller sessionSeller);
}
