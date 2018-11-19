package com.secondhand.user.service;

public interface BuycarService {
	//统计购物车中某商品的总数量
	public Integer countFromBuycar(Integer uid, Integer pid);
}
