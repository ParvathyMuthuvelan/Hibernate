package com.client;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.Order;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.pojo.Emp;
import com.util.HibernateUtil;

public class HQLDemo {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();

		System.out.println("session =" + session);
		Transaction tx = session.beginTransaction();
		System.out.println("Search employee by Id");
		Query query = session.createQuery("from Emp where empId= :id ");
		query.setParameter("id", 102);
		Emp e = (Emp) query.getSingleResult();
		System.out.println(e);

		System.out.println("Sorting employee records");
		query = session.createQuery("from Emp e order by e.empSal desc");
		List<Emp> empList = query.getResultList();
		empList.forEach(emp -> System.out.println(emp));

		query = session.createQuery("select max(e.empSal) as maxSalary from Emp e");
		Object listResult = query.getSingleResult();

		Double salary = (Double) listResult;

		System.out.println("Maximum salary" + " - " + salary);

		Criteria crit = session.createCriteria(Emp.class);

		// crit.add(Restrictions.ge("empSal", 10000.00));
		System.out.println("Employees with salary 15000 to 50000");
		crit.add(Restrictions.and((Restrictions.ge("empSal", 15000.00)), (Restrictions.le("empSal", 50000.00))));
		// crit.addOrder(Order.("empName"));
		List<Emp> lst = crit.list();
		lst.forEach(emp -> System.out.println(emp));
		tx.commit();
		session.close();
	}

}
