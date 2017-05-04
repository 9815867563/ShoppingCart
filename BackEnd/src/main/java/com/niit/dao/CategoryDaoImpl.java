package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.domain.Category;
import com.niit.domain.Category;

@Repository("cdao")
@Transactional
@Component
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	Category category;

	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();

	}

	public List<Category> list() {
		return getCurrentSession().createQuery("from Category").list();
	}

	public boolean insert(Category Category) {
		try {

			System.out.println("insert is called*******");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(category);
			tx.commit();
			session.flush();
			session.close();
			return true;

		} catch (Exception e) {
			// if any excpetion comes during execute of try block, catch will
			// excute
			e.printStackTrace();
			return false;
		}
	}

	public boolean save(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(category);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(category);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public Category getCategoryById(String id) {
		// TODO Auto-generated method stub
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);

	}

	public Category getCategoryByName(String name) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from Category where name=?");
		// Query query;
		query.setString(0, name);
		return (Category) query.uniqueResult();
	}

}
