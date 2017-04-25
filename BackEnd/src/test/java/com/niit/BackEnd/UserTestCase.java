package com.niit.BackEnd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDao;
import com.niit.dao.UserDaoImpl;
import com.niit.domain.User;

/**
 * Unit test for simple App.
 */
public class UserTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static UserDao userDao;

	@Autowired
	static User user;

	// The above objects need to initialize
	/**
	 * This method is going execute before calling any one of test case and will
	 * execute only once
	 */
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		// get the userDAO from context
		// get the user from context

		userDao = (UserDao) context.getBean(UserDaoImpl.class);
		
		user=context.getBean(User.class);

	}

	@Test
	public void createUserTestCase() {
		user.setId("3");
		user.setName("Suveen Kumar");
		user.setPassword("suveen");
		user.setRole("ROLE_USER");
		user.setMobile(9815);
		boolean flag = userDao.save(user);
		System.out.println("saved");
		assertEquals("UserTestCase", true, flag);
		// sa

	}

	// TODO Auto-generated method stub

}
