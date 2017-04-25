package com.niit.dao;

import org.h2.engine.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.domain.Cart;

public class CartDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;
	//public Cart getCart(int cartId) {
	//	Session session = sessionFactory.openSession();
	//	Cart cart=(Cart)session.get(Cart.class, cartId);
	//	session.close();
				
	//	return cart;
		
		
	//}
	
	//public Cart validate(int cartId) throws IOException{
	//	Cart cart=getCart(cartId);
		//if(cart.getCartItems().size()==0 || cart==null)
		//	throw new IOException(cartId +"");
		//return cart;
		
		
	}
//}
