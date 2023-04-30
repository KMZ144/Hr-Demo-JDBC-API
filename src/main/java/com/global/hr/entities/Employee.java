package com.global.hr.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("employee")
public class Employee {
	
	@Id
	@Column("id")
	private long id;
	private String name;
	
	private int salary;
	
	@Transient
	Boolean isCreated; 
	
	public Employee(long id, String name, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public Boolean getIsCreated() {
		return isCreated;
	}
	public void setIsCreated(Boolean isCreated) {
		this.isCreated = isCreated;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	

}
