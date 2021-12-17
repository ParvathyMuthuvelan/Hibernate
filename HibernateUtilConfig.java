package com.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.onetomany.Department;
import com.onetomany.Employee;
import com.onetomany.Skill;
import com.onetoone.Author;
import com.onetoone.Book;
import com.pojo.Student;

public class HibernateUtilConfig {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/ormnew?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "root");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(Environment.SHOW_SQL, "true");

				//settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "validate");

				configuration.setProperties(settings);

			//	configuration.addAnnotatedClass(Student.class);
			
		
			//	configuration.addAnnotatedClass(Book.class);
				//configuration.addAnnotatedClass(Author.class);
				configuration.addAnnotatedClass(Employee.class);
				configuration.addAnnotatedClass(Department.class);
				configuration.addAnnotatedClass(Skill.class);
				//The main purpose of a service registry is to hold, manage and provide access to services.
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
