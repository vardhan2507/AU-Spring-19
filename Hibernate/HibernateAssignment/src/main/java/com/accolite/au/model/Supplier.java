package com.accolite.au.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Supplier {

	@Id
	int id;
	
	String name;

	@OneToMany(cascade={CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
	Collection<Vehicle> vehciles;

	public Collection<Vehicle> getVehciles() {
		return vehciles;
	}

	public void setVehciles(Collection<Vehicle> vehciles) {
		this.vehciles = vehciles;
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

}
