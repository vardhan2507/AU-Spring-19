package com.accolite.au.model;

import javax.persistence.*;

@Entity
@Table(name="Employee")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	 @AttributeOverrides({
	        @AttributeOverride(name = "city", column = @Column(name="home_city")),
	        @AttributeOverride(name = "street", column = @Column(name="home_street")),
	    })
	    private Address homeAddress;
	 
	    @Embedded
	    private Address officeAddress;

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

		public Address getHomeAddress() {
			return homeAddress;
		}

		public void setHomeAddress(Address homeAddress) {
			this.homeAddress = homeAddress;
		}

		public Address getOfficeAddress() {
			return officeAddress;
		}

		public void setOfficeAddress(Address officeAddress) {
			this.officeAddress = officeAddress;
		}
	    
	    

}
