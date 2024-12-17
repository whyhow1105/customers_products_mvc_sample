package com.sample.customersproducts.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customers extends Maintenance {
	
	@Column(name = "First_Name")
	private String firstName;
	
	@Column(name = "Last_Name")
	private String lastName;
	
	@Column(name = "Office_Email")
	private String officeEmail;
	
	@Column(name = "Personal_Email")
	private String personalEmail;
	
	@OneToMany(mappedBy = "customersId", fetch = FetchType.LAZY)
	private List<FamilyMembers> familyMembers;

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

	public String getOfficeEmail() {
		return officeEmail;
	}

	public void setOfficeEmail(String officeEmail) {
		this.officeEmail = officeEmail;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public List<FamilyMembers> getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(List<FamilyMembers> familyMembers) {
		this.familyMembers = familyMembers;
	}

	public Customers() {
		super();
	}
	
}
