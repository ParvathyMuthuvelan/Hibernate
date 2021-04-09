package com.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pojo.Emp;
import com.util.HibernateUtil;

public class UpdateEmp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Session session =HibernateUtil.getSession();

		Transaction tx = session.beginTransaction();
		Emp emp = (Emp)session.get(Emp.class, 102);
		//session.delete(emp);
		
		emp.setEmpSal(70000.00);
		session.update(emp);
		tx.commit();
		System.out.println("row updated successfully");
		session.close();

	}

}
