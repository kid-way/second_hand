package com.secondhand.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secondhand.user.dao.UserDao;
import com.secondhand.user.entity.User;
import com.secondhand.user.exception.LoginException;
import com.secondhand.user.exception.RegistException;
import com.secondhand.user.exception.UpdateException;
import com.secondhand.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Override
	public User login(String username,String password) throws LoginException {
		User sqlUser = userDao.findUserByUsername(username);
		if(sqlUser==null){
			throw new LoginException("用户不存在");
		}else{
			String sqlPassword = sqlUser.getPassword();
			if(!password.equals(sqlPassword)){
				throw new LoginException("用户密码错误！");
			}else{
				return sqlUser;
			}
		}
	}
	@Override
	public void regist(User user) throws RegistException {
		String username = user.getUsername();
		String uphone = user.getUphone();
		User sqlUser1 = userDao.findUserByUsername(username);
		User sqlUser2 = userDao.findUserByUphone(uphone);
		if(sqlUser1 != null){
			throw new RegistException("该用户名已存在！");
		}else if(sqlUser2 != null){
			throw new RegistException("该手机号已被注册");
		}else{
			userDao.addUser(user);
		}
	}
	@Override
	public User update(User user,User sessionUser) {
		User sqlUser = userDao.findUserByUsername(user.getUsername());
		User sqlUser2 = userDao.findUserByUphone(user.getUphone());
		if(sqlUser != null && !sessionUser.getUsername().equals(sqlUser.getUsername())){
			throw new UpdateException("用户名已被注册");
		}else if(sqlUser2 != null && !sessionUser.getUphone().equals(sqlUser2.getUphone())){
			throw new UpdateException("该手机号已被注册！");
		}else{
			int i = userDao.update(user);
			if(i==1){
				return user;
			}else{
				throw new UpdateException("修改失败");
			}
		}
	}
}
