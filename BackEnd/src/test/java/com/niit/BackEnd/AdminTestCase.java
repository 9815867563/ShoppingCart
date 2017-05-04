package com.niit.BackEnd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.AdminDao;
import com.niit.dao.AdminDaoImpl;
import com.niit.domain.Admin;

/**
 * Unit test for simple App.
 */
public class AdminTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static AdminDao adminDao;

	@Autowired
	static Admin admin;

	// The above objects need to initialize
	/**
	 * This method is going execute before calling any one of test case and will
	 * execute only once
	 */
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		// get the AdminDAO from context
		// get the Admin from context

		adminDao = (AdminDao) context.getBean("adminD");
		
		admin=context.getBean(Admin.class);

	}

	@Test
	public void createAdminTestCase() {
		admin.setId("8");
		admin.setName("Suveen Kumar");
		admin.setPassword("suveen");
		admin.setRole("ROLE_Admin");
		//Admin.setMobile(9815);
		boolean flag = ( adminDao).insert(admin);
		System.out.println("saved");
		assertEquals("AdminTestCase", true, flag);
		// sa

	}

	// TODO Auto-generated method stub

}
