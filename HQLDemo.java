package com.client;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
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
		query.setParameter("id", 112);
		Emp e = (Emp) query.getSingleResult();
		System.out.println(e);

		System.out.println("Sorting employee records based on salary");
		query = session.createQuery("from Emp e order by e.empSal ");
		List<Emp> empList = query.getResultList();
		empList.forEach(emp -> System.out.println(emp));
		

		query = session.createQuery("select max(e.empSal) as maxSalary from Emp e");
		Object listResult = query.getSingleResult();

		Double salary = (Double) listResult;

		System.out.println("Maximum salary" + " - " + salary);

		System.out.println("Criteria demo");
		
		Criteria crit = session.createCriteria(Emp.class);
		System.out.println("Employees with salary greater than 10000");
		crit.add(Restrictions.ge("empSal", 20000.00));
		List<Emp> lst = crit.list();
		lst.forEach(emp -> System.out.println(emp));
		
		
		System.out.println("Employees with salary 15000 to 50000");
		crit.add(Restrictions.and((Restrictions.ge("empSal", 15000.00)), (Restrictions.le("empSal", 50000.00))));
		//crit.addOrder(Order.("empName"));
		lst = crit.list();
		lst.forEach(emp -> System.out.println(emp));
		
		System.out.println("Employees in department Admin");
		crit.add(Restrictions.eq("dept","Admin"));
		List<Emp> results = crit.list();
		results.forEach(emp -> System.out.println(emp));
		
		System.out.println("Checking with null vaalue");
		crit.add(Restrictions.isNull("dept"));
		results = crit.list();
		results.forEach(emp -> System.out.println(emp));
		
		System.out.println("Checking with like ");
		Criterion salaryLessThan = Restrictions.lt("empSal", 50000.0);
		Criteria criteria = session.createCriteria(Emp.class);
		Criterion name = Restrictions.ilike("empName", "b%", MatchMode.ANYWHERE);
		LogicalExpression orExp = Restrictions.or(salaryLessThan, name);
		//crit.add(orExp);
		criteria.add(name);
		 results=criteria.list();
		 results.forEach(emp -> System.out.println(emp));
		 System.out.println("count="+results.size());
		 results.forEach(emp -> System.out.println(emp));
		 
		// crit.add(Restrictions.gt("empSal",50000.0));
		// crit.addOrder(Order.desc("empSal"));
		 //results = crit.list();
		 //results.forEach(emp -> System.out.println(emp));
		 
		tx.commit();
		session.close();
	}

}
