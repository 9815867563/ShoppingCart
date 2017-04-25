package com.niit.testcase;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDao;
import com.niit.dao.UserDaoImpl;
import com.niit.domain.User;

public class DriverClass {

	public static void main(String[] args) {
		System.out.println("Before");
			AnnotationConfigApplicationContext config=new AnnotationConfigApplicationContext();
			config.scan("com.niit");
			config.refresh();
			
			User user1=new User();
			user1.setId("2");
			user1.setName("ABC");
			user1.setPassword("abc");
			user1.setRole("ROLE_USER");
			user1.setMobile(1234);
			
			UserDao userDao=config.getBean(UserDaoImpl.class);
			System.out.println(userDao.save(user1));
		
			System.out.println("After");

	}

}
