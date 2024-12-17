package com.sample.customersproducts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Family_Members")
public class FamilyMembers extends Maintenance {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Customers_Id", nullable = false)
	private Customers customersId;
	
	@Column(name = "First_Name")
	private String firstName;
	
	@Column(name = "Last_Name")
	private String lastName;

	public Customers getCustomersId() {
		return customersId;
	}

	public void setCustomersId(Customers customersId) {
		this.customersId = customersId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public FamilyMembers() {
		super();
	}
}
