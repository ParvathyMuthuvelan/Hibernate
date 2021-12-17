package com.onetomany;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.util.HibernateUtilConfig;

public class ManytoManyClient {

	public static void main(String[] args) {
		System.out.println("ManytoMany client");
		Session session = HibernateUtilConfig.getSessionFactory().openSession();
		session.beginTransaction();
		// Insert into Department table
	/*Department dept = new Department();
		dept.setName("Chennai");
		session.save(dept);
		dept=new Department();
		dept.setName("Mumbai");
		session.save(dept);

		// Insert into Employee table
Department dep=session.get(Department.class, 1);
		Employee emp = new Employee();
		emp.setName("Sri");
		emp.setPermanent(true);
		emp.setSalary(45000);
		emp.setDateOfBirth(new Date());
		emp.setDepartment(dep);
		session.save(emp);

		emp = new Employee();
		emp.setName("Minu");
		emp.setPermanent(false);
		emp.setSalary(45000);
		emp.setDateOfBirth(new Date());
		emp.setDepartment(dep);
		session.save(emp);
 session.getTransaction().commit();*/
		// To find employee--> department (many to one)
/*System.out.println("employee --> department");
		Employee employee = session.get(Employee.class,2);
		System.out.println(employee);
		System.out.println("Id :"+employee.getId());
		System.out.println("Name:"+employee.getName());
		System.out.println("Department:"+employee.getDepartment().getName());*/
		

		// To find department-->employee (one to many)
	/*	System.out.println("department --> employee");
		Department d=session.get(Department.class,1);
		System.out.println("Dept name=" + d.getName());
		List<Employee> empList = d.getEmployeeList();
System.out.println("list size="+empList.size());
		empList.forEach(e -> System.out.println(e));*/

		// Insert into skill table
//Skill skill1=new Skill();
//		 skill1.setName("Java");
//		 session.save(skill1);
//		Skill  skill2=new Skill();
//	skill2.setName("Hibernate");
//		 session.save(skill2);
//		 Skill skill3=new Skill();
//		 skill3.setName("Spring");
//		 session.save(skill3);
		//   session.getTransaction().commit();
		// Employee - skill (many - many)
		Set<Skill> skillSet = new HashSet<>();
		Employee e = session.get(Employee.class, 2);
		Skill s1=session.get(Skill.class, 1);
		skillSet.add(s1);
		Skill s2=session.get(Skill.class, 2);
		skillSet.add(s2);
  
		e.setSkillList(skillSet);
		session.save(e);
		
	   session.getTransaction().commit();
	/*	Employee emp = empService.get(2);
		System.out.println(emp.getName());
		Set<Skill> skills = emp.getSkillList();
		for (Skill sk : skills) {
			System.out.println(sk);
		}*/
session.close();
	}

}
