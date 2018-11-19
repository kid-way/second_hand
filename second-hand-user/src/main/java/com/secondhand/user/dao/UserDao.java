package com.secondhand.user.dao;


import com.secondhand.user.entity.User;

/**
 *<p>Title: UserDao</p>
*<p>Description: 用户的Dao接口</p>
*@author kid_way
*@date 2018-1-4 下午2:41:30
 */
public interface UserDao {
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	public User findUserByUsername(String username);
	
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user);

	/**
	 * 根据用户手机查找用户
	 * @param uphone
	 * @return
	 */
	public User findUserByUphone(String uphone);
	
	public int update(User user);
}
