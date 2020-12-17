package com.example.restservice.model.response;

import java.util.ArrayList;
import java.util.Date;

import com.example.restservice.model.data.Employee;
import com.example.restservice.model.data.Link;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeResponse {
	
	private int id;
	private String name;
	private double salary;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	
	private ArrayList<Link> links;
	
	public EmployeeResponse(@JsonProperty("employee") Employee employee) {
		this.id = employee.getId();
		this.name = employee.getName();
		this.salary = employee.getSalary();
		this.links = employee.getLinks();
		this.birthday = employee.getBirthday();
	}

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public ArrayList<Link> getLinks() {
		return links;
	}

	public void setLinks(ArrayList<Link> links) {
		this.links = links;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	
}
