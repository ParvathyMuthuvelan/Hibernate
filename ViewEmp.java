package com.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pojo.Emp;
import com.util.HibernateUtil;
import com.util.HibernateUtil1;

public class ViewEmp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		
		Session session = HibernateUtil.getSession();
		Emp emp =  session.get(Emp.class, 101);
   if (emp != null){
        System.out.println(emp);
        }else{
        	 System.out.println("Invalid employee id");
       }
         
		session.close();

		
		
	}

}
