package com.client;

import org.hibernate.Session;

import org.hibernate.Transaction;

import com.pojo.Emp;
import com.util.HibernateUtil;

public class SaveEmp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();

		System.out.println("session =" + session);
		Transaction tx = session.beginTransaction();
		Emp emp = new Emp();
		emp.setEmpId(102);
		emp.setEmpName("bala");
		emp.setDept("SD");
		emp.setEmpSal(15000.00);

		Emp emp1 = new Emp();
		emp1.setEmpId(103);
		emp1.setEmpName("basheer");
		emp1.setDept("HR");
		emp1.setEmpSal(25000.00);

		Emp emp2 = new Emp();
		emp2.setEmpId(104);
		emp2.setEmpName("jack");
		emp2.setDept("CEO");
		emp2.setEmpSal(45000.00);

		session.save(emp);
		session.save(emp1);
		session.save(emp2);

		tx.commit();

		session.close();

	}

}
