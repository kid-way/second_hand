package com.secondhand.user.dao;

import org.apache.ibatis.annotations.Param;

import com.secondhand.user.entity.Buycar;

public interface BuycarDao {
	
	public void add(Buycar buycar);
	
	public void delete(String[] iid);

	public void deleteItem(String iid);

	public Integer countFromBuycar(@Param("uid") Integer uid, @Param("pid") Integer pid);
}
