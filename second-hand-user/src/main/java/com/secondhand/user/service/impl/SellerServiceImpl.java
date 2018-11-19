package com.secondhand.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.secondhand.user.dao.SellerDao;
import com.secondhand.user.entity.Seller;
import com.secondhand.user.exception.LoginException;
import com.secondhand.user.exception.RegistException;
import com.secondhand.user.exception.UpdateException;
import com.secondhand.user.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SellerDao sellerDao;
	
	public Seller login(String sname, String password) throws LoginException {
		Seller seller = sellerDao.findSellerBySname(sname);
		if(seller==null){
			throw new LoginException("该卖家用户名不存在");
		}else if(!seller.getPassword().equals(password)){
			throw new LoginException("密码错误");
		}else{
			return seller;
		}
	}

	@Transactional
	public void regist(Seller seller) throws RegistException {
		String sname = seller.getSname();
		String sphone = seller.getSphone();
		Seller sqlSeller = sellerDao.findSellerBySname(sname);
		Seller sqlSeller2 = sellerDao.findSellerBySphone(sphone);
		if(sqlSeller!=null){
			throw new RegistException("该卖家用户名已被注册");
		}else if(sqlSeller2!=null){
			throw new RegistException("该手机号已被注册");
		}else{
			sellerDao.addSeller(seller);
		}
	}

	@Override
	public Seller findBySname(String sname) {
		Seller seller = sellerDao.findSellerBySname(sname);
		return seller;
	}

	@Override
	public Seller findBySphone(String sphone) {
		Seller seller = sellerDao.findSellerBySphone(sphone);
		return seller;
	}

	@Override
	@Transactional
	public Seller update(Seller seller,Seller sessionSeller) {
		Seller sqlSeller = sellerDao.findSellerBySname(seller.getSname());
		Seller sqlSeller2 = sellerDao.findSellerBySphone(seller.getSphone());
		if(sqlSeller != null && !sessionSeller.getSname().equals(sqlSeller.getSname())){
			throw new UpdateException("卖家名已被注册");
		}else if(sqlSeller2 != null && !sessionSeller.getSphone().equals(sqlSeller2.getSphone())){
			throw new UpdateException("该手机号已被注册！");
		}else{
			sellerDao.update(seller);
			return seller;
		}
	}
}
