package com.niit.BackEnd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDao;
import com.niit.dao.CategoryDaoImpl;
import com.niit.domain.Category;

public class CategoryTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static CategoryDao categoryDao;

	@Autowired
	static Category category;

	// The above objects need to initialize
	/**
	 * This method is going execute before calling any one of test case and will
	 * execute only once
	 */
	@Before
	public void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		// get the CategoryDAO from context
		// get the Category from context

		categoryDao = (CategoryDao) context.getBean("cdao");
		System.out.println(categoryDao);

		category = context.getBean(Category.class);
		System.out.println(category);

	}

	@Test
	public void createCategoryTestCase() {
		category.setId("3433");
		category.setName("clothing");
		category.setDescription("clothes");

		// Category.setMobile(9815);
		boolean flag = categoryDao.insert(category);
		System.out.println("saved");
		assertEquals("CategoryTestCase", true, flag);
		
	}

}
