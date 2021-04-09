package com.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pojo.Emp;
import com.pojo.Student;
import com.util.HibernateUtil;

public class ViewAllEmployees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Session session = HibernateUtil.getSession();
		
       List<Emp> lst =session.createQuery("from Emp", Emp.class).list();
       System.out.println(lst.size());
         for(Emp e: lst){
        	 System.out.println(e);
         }
       
        
         System.out.println("rows viewed successfully");
         
		
		session.close();
	}

}
