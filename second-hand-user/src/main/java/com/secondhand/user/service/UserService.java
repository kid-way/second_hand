package com.secondhand.user.service;

import com.secondhand.user.entity.User;
import com.secondhand.user.exception.LoginException;
import com.secondhand.user.exception.RegistException;

public interface UserService {
	/**
	 * 用户登录service
	 * @param username password
	 * @return
	 * @throws LoginException
	 */
	public User login(String username,String password) throws LoginException;
	
	/**
	 * 用户注册service
	 * @param user
	 * @throws RegistException
	 */
	public void regist(User user) throws RegistException;

	public User update(User user,User sessionUser);
}
