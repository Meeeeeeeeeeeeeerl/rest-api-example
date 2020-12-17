package com.example.restservice.model.data;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Adress {
	private int id;
	private String street;
	private String postCode;
	private String city;
	private String country;
	private ArrayList<Link> links;
	
	public Adress(@JsonProperty("id") int id, @JsonProperty("street") String street, @JsonProperty("postCode") String postCode, @JsonProperty("city") String city, @JsonProperty("country") String country) {
		this.id = id;
		this.street = street;
		this.postCode = postCode;
		this.city = city;
		this.country = country;
		
		this.links = new ArrayList<Link>();
		links.add(new Link("self", "/api/v1/employee/" + id + "/adress"));
		links.add(new Link("employee", "/api/v1/employee/" + id));
	}

	public ArrayList<Link> getLinks() {
		return links;
	}

	public void setLinks(ArrayList<Link> links) {
		this.links = links;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
}