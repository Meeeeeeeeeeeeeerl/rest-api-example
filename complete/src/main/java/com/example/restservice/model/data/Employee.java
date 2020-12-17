package com.example.restservice.model.data;
import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
	private int id;
	private String name;
	private double salary;
	private Adress adress;
	private ArrayList<Link> links;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	
	public Employee(@JsonProperty("id") int id, @JsonProperty("name") String name, @JsonProperty("salary") double salary, @JsonProperty("birthday") Date birthday, @JsonProperty("street") String street, @JsonProperty("postCode") String postCode, @JsonProperty("city") String city, @JsonProperty("country") String country) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.birthday = birthday;
		this.adress = new Adress(id, street, postCode, city, country);
		
		this.links = new ArrayList<Link>();
		links.add(new Link("self", "/api/v1/employee/" + id));
		links.add(new Link("adress", "/api/v1/employee/" + id + "/adress"));
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
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

	public void setSalary(double d) {
		this.salary = d;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public ArrayList<Link> getLinks() {
		return links;
	}

	public void setLinks(ArrayList<Link> links) {
		this.links = links;
	}
}