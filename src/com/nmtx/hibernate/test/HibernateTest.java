package com.nmtx.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.nmtx.hibernate.domain.Customer;
import com.nmtx.hibernate.utils.HibernateUtils;

/**
 * hibernate��������
 * @author nmtxzl
 *
 */
public class HibernateTest {
	
	@Test
	public void baseTest() {
		
		Configuration conf = new Configuration().configure();
		
		SessionFactory sessionFactory = conf.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
	
		Transaction tx = session.beginTransaction();
		Customer customer = new Customer();
		customer.setCust_name("��������");
		customer.setCust_level("one");
		
		session.save(customer);//ִ�б���
		
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void add() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Customer cust = new Customer();
		cust.setCust_name("����һ��");
		session.save(cust);
		
		transaction.commit();
		session.close();
	}
	
	@Test
	public void delete() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		Customer customer = session.get(Customer.class, 2l);
		session.delete(customer);
		transaction.commit();
		session.close();
	}
	
	@Test
	public void update() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		Customer customer = session.get(Customer.class, 2l);
		customer.setCust_level("�ڶ���");
		session.update(customer);
		transaction.commit();
		session.close();
	}
	
	@Test
	public void query() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		Customer customer = session.get(Customer.class, 1l);
		System.out.println(customer);
		transaction.commit();
		session.close();
	}
	
	
	
	
	

}
