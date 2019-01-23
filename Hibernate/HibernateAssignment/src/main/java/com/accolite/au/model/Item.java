package com.accolite.au.model;

import javax.persistence.*;

@Entity(name="Item")
public class Item {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;

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
	
	

}
