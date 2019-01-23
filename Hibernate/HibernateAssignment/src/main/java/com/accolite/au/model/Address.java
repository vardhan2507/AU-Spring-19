package com.accolite.au.model;

import javax.persistence.*;

@Entity(name="Address")
@Embeddable
@Table(name="Address")
public class Address {
	
	@Id
	int id;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
