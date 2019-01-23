package com.accolite.au.model;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class Customer{
	
	@Id
	int id;
	String name;
	
	@OneToOne(cascade = {CascadeType.ALL})
	Vehicle vehcile;
	
	public int getId() {
		return id;
	}
	public Vehicle getVehcile() {
		return vehcile;
	}
	public void setVehcile(Vehicle vehcile) {
		this.vehcile = vehcile;
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
	
	
	
	
}
