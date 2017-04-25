package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.apache.commons.dbcp2.BasicDataSource;
//import org.apache.commons.dbcp2.datasources.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import com.niit.dao.UserDao;
import com.niit.dao.UserDaoImpl;
import com.niit.domain.User;

//import com.niit.dao.ProductDao;
//import com.niit.dao.ProductDaoImp;
//import com.niit.model.Product;

@Configuration
@ComponentScan("com.niit")
public class ApplicationContextConfig {

	@Bean
	public DataSource getH2DataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:tcp://localhost/~/test");
		ds.setUsername("sa");
		ds.setPassword("");
		return ds;
	}

	private Properties getHibernateProperties() {
		Properties p = new Properties();
		p.put("hibernate.show_sql", "true");
		p.put("hibenate.dilect", "org.hibernate.dilect.H2Dilect");
		p.put("hibernate.hbm2ddl.auto", "update");
		return p;

	}

	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addProperties(getHibernateProperties());

		return sessionBuilder.buildSessionFactory();
	}


	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;

	}

	@Autowired
	@Bean(name = "userDao")
	public UserDao getUserDao(SessionFactory sessionFactory) {
		return new UserDaoImpl(sessionFactory);
	}

}

