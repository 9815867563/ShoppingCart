package com.niit.testcase;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDao;
import com.niit.domain.Category;


public class DiverClass2 {

	public static void main(String[] args) {
		System.out.println("Before");
			AnnotationConfigApplicationContext config=new AnnotationConfigApplicationContext();
			config.scan("com.niit");
			config.refresh();
			
			Category category1=new Category();
			category1.setId("5");
			category1.setName("ABC");
			category1.setDescription("Clothing");
			
			
			CategoryDao categoryDao=(CategoryDao) config.getBean("CategoryDao");
		
			System.out.println(categoryDao.insert(category1));
			
		
			System.out.println("After");

	}

}
