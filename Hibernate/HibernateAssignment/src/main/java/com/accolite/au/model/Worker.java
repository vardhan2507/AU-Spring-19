package com.accolite.au.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity(name="Worker")
@Table(name="Worker")
public class Worker {
	
	@Id
	int id;
	
	private int dailyWage;
	
	 @ElementCollection
     private Collection<Address> lisOfAddresses = new ArrayList<Address>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDailyWage() {
		return dailyWage;
	}

	public void setDailyWage(int i) {
		this.dailyWage = i;
	}

	public Collection<Address> getLisOfAddresses() {
		return lisOfAddresses;
	}

	public void setLisOfAddresses(Collection<Address> lisOfAddresses) {
		this.lisOfAddresses = lisOfAddresses;
	}
	
	 

}
