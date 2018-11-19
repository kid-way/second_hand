package com.secondhand.user.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.secondhand.user.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:spring/spring-dao.xml",
	"classpath:spring/spring-service.xml"})
public class UserServiceTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testLogin() {
		//com.secondhand.user.exception.LoginException: 用户密码错误！
		//User user = userService.login("伍克伟", "345678");
		
		//com.secondhand.user.exception.LoginException: 用户不存在
		//User user = userService.login("伍", "12345678");
		
		//INFO  c.s.user.service.UserServiceTest - 
		//user=User [uid=1, username=伍克伟, password=12345678, uphone=13543811425, gender=1, age=25]
		User user = userService.login("伍克伟", "12345678");
		logger.info("user={}",user);
	}
	
	@Test
	public void testRegist(){

		// Preparing: insert into user(username,password,uphone,gender,age) values(?,?,?,?,?) 
		//[main] DEBUG c.s.user.dao.UserDao.addUser - ==> Parameters: 李四(String), 123321(String), 11112222(String), 1(Integer), 18(Integer)
		//[main] DEBUG c.s.user.dao.UserDao.addUser - <==    Updates: 1
		/*User user = new User();
		user.setAge(18);
		user.setGender(1);
		user.setPassword("123321");
		user.setUphone("11112222");
		user.setUsername("李四");
		userService.regist(user);*/
		
		//同一个人再注册一遍
		//com.secondhand.user.exception.RegistException: 该用户名已存在！
		/*User user = new User();
		user.setAge(18);
		user.setGender(1);
		user.setPassword("123321");
		user.setUphone("11112222");
		user.setUsername("李四");
		userService.regist(user);*/
		
		//用户名不同，手机号相同
		//com.secondhand.user.exception.RegistException: 该手机号已被注册
		User user = new User();
		user.setAge(18);
		user.setGender(1);
		user.setPassword("123321");
		user.setUphone("11112222");
		user.setUsername("李白");
		userService.regist(user);
	}
}
