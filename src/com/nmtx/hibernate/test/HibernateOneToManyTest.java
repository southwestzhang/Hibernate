package com.nmtx.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.nmtx.hibernate.domain.Customer;
import com.nmtx.hibernate.domain.LinkMan;
import com.nmtx.hibernate.utils.HibernateUtils;

/**
 * һ�Զ�
 * @author nmtxzl
 *
 */
public class HibernateOneToManyTest {
	
	@Test
	public void base() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Customer cust = new Customer();
		cust.setCust_name("��ӹ");
		
		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("�ɺ��⴫");
		LinkMan lm2 = new LinkMan();
		lm2.setLkm_name("ѩɽ�ɺ�");
		
		cust.getLinkMans().add(lm1);
		cust.getLinkMans().add(lm2);
		
		lm1.setCustomer(cust);
		lm2.setCustomer(cust);
		
		session.save(cust);
		session.save(lm1);
		session.save(lm2);
		
		transaction.commit();
		session.close();
		
	}
	
	

}
