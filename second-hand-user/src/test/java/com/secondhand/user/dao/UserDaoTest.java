package com.secondhand.user.dao;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.secondhand.user.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {
	@Autowired
	private UserDao userDao;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindUserByUsername() {
		String username = "伍克伟";
		User user = userDao.findUserByUsername(username);
		System.out.println(user);
	}

	@Test
	public void testAddUser() {
		User user = new User();
		user.setAge(10);
		user.setGender(0);
		user.setPassword("1352783");
		user.setUphone("1238493");
		user.setUsername("陈锦鸿");
		userDao.addUser(user);
	}

}
