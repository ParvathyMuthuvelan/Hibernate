package com.onetomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dept")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="dp_id")
	private int id; 
	@Column(name="dp_name")
	private String name;
	
	@OneToMany(mappedBy = "department",fetch = FetchType.EAGER)
	private List<Employee> employeeList; 

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> empList) {
		this.employeeList = empList;
	}
	@Override
	public String toString() {
		return String.format("Department [id=%s, name=%s]", id, name);
	} 
	

}
