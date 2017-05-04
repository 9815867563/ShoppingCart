
package com.niit.dao;

import java.util.List;

//import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;

import com.niit.domain.Admin;

//import com.niit.shoppingcart.dao.AdminDAO;
//import com.niit.shoppingcart.domain.Admin;

//Note : we will get errors  - will soleve tomorrow

@Repository("adminD")
@Transactional
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SessionFactory sessionFactory;

	// write Admin defined constructor with one parameter i.e., sessionFactory

	// public AdminDaoImpl(SessionFactory sessionFactory) {
	// this.sessionFactory = sessionFactory;
	// }

	/**
	 * This save method create record in the Admin table. If the record is
	 * created successfully, it will return true else will return false
	 */

	public boolean insert(Admin Admin) {
		try {

			System.out.println("insert i scalled*******");
			// sessionFactory.getCurrentSession().save(Admin);
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			//Admin.setRole("ROLE_Admin");
			session.save(Admin);
			tx.commit();
			session.flush();
			session.close();

		} catch (Exception e) {
			// if any excpetion comes during execute of try block, catch will
			// excute
			e.printStackTrace();
			// return false;
		}
		// return true;
		return true;
	}

	/**
	 * This update method update record in the Admin table. If the record is
	 * updated successfully, it will return true else will return false
	 */
	public boolean update(Admin Admin) {
		try {
			sessionFactory.getCurrentSession().update(Admin);
		} catch (Exception e) {
			// if any excpetion comes during execute of try block, catch will
			// excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * validate method will return true if the credetails are correct else will
	 * return false
	 */
	public boolean validate(String id, String password) {

		Query query = sessionFactory.getCurrentSession().createQuery("from Admin where name = ? and password = ?");
		query.setString(0, id); // actually the index will start from zero -
									// will get once exception.
		query.setString(1, password);
		// in the Admin table with this id and password there will one or zero
		// records will exist
		// i.e., uniqueResult
		// uniqueResult method will return object if a row exist, else it will
		// return null
		if (query.uniqueResult() == null) {
			// means no row exist i.e., invalid credentials
			return false;
		} else {
			// means row exist i.e., valid credentials
			return true;
		}

	}

	public List<Admin> list() {

		
		
		return sessionFactory.getCurrentSession().createQuery("from Admin").list();
	}

	public Admin get(String id) {

		// get method get the date from Admin table based on primary key i.e., id
		// and set it to Admin class
		// like select * from Admin where id = ?
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Admin where  name=?");
		query.setString(0, id);
		Admin Admin = (Admin) query.uniqueResult();
		tx.commit();
		session.flush();
		session.close();
		return Admin;

	}

}
