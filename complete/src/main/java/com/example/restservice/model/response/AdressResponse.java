package com.example.restservice.model.response;

import java.util.ArrayList;
import com.example.restservice.model.data.Adress;
import com.example.restservice.model.data.Link;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AdressResponse {
	
	private int id;
	private String street;
	private String postCode;
	private String city;
	private String country;
	private ArrayList<Link> links;
	
	public AdressResponse(@JsonProperty("adress") Adress adress) {
		this.id = adress.getId();
		this.street = adress.getStreet();
		this.postCode = adress.getPostCode();
		this.city = adress.getCity();
		this.country = adress.getCountry();
		this.links = adress.getLinks();
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

	public ArrayList<Link> getLinks() {
		return links;
	}

	public void setLinks(ArrayList<Link> links) {
		this.links = links;
	}


	
}
