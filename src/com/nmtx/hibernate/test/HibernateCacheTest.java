package com.nmtx.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.nmtx.hibernate.domain.Customer;
import com.nmtx.hibernate.utils.HibernateUtils;

/**
 * Hibernateһ���������
 * @author nmtxzl
 *
 */
public class HibernateCacheTest {
	
	@Test
	public void sessionCacheTest() {
		Session session = HibernateUtils.openSession();
		Customer cust = session.get(Customer.class, 2l);
		System.out.println(cust.getCust_name());
		
		Customer cust2 = session.get(Customer.class, 2l);
		System.out.println(cust2.getCust_name());
		
		System.out.println("cust==cust2: "+(cust==cust2));
	}
	
	//Hibernate���� --- ����
	@Test
	public void sessionCacheTest2() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Customer cust = session.get(Customer.class, 2l);
		System.out.println(cust.getCust_name());
		
		cust.setCust_name("����");
		
		cust.setCust_name("����");
		
		transaction.commit();
		session.close();
		
	
	}
	
	
	
	
	
	
	

}
