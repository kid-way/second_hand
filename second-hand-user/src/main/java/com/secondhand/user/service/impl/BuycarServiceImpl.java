package com.secondhand.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secondhand.user.dao.BuycarDao;
import com.secondhand.user.service.BuycarService;

@Service
public class BuycarServiceImpl implements BuycarService {
	
	@Autowired
	private BuycarDao buycarDao;
	
	@Override
	public Integer countFromBuycar(Integer uid, Integer pid) {
		Integer count = buycarDao.countFromBuycar(uid, pid);
		return count;
	}

}
