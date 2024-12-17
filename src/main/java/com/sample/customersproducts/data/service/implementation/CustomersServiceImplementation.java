package com.sample.customersproducts.data.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.customersproducts.model.Customers;
import com.sample.customersproducts.model.FamilyMembers;
import com.sample.customersproducts.repository.CustomersRepository;
import com.sample.customersproducts.repository.FamilyMembersRepository;

@Service
public class CustomersServiceImplementation extends AbstractServiceImplementation<Customers, String>{
	
	@Autowired
	CustomersRepository customersRepository;
	
	@Autowired
	FamilyMembersRepository familyMembersRepository;
	
	@Override
	public Customers add(Customers customer) {
		this.logInfo("add", null);
		
 		if (null != customer.getFamilyMembers() && !customer.getFamilyMembers().isEmpty()) {
			Customers cust = customersRepository.save(customer);
			
			List<FamilyMembers> listOfMember = new ArrayList<FamilyMembers>();
			
			for (FamilyMembers familyMembers: customer.getFamilyMembers()) {
				familyMembers.getCustomersId().setId(cust.getId());
				familyMembers = familyMembersRepository.save(familyMembers);
				listOfMember.add(familyMembers);
			}
			
			cust.setFamilyMembers(listOfMember);
			
			return cust;
			
		} else {
			return super.add(customer);
		}
	}
	
	@Override
	public Customers update(Customers customer) {
		this.logInfo("update", null);
		
 		if (null != customer.getFamilyMembers() && !customer.getFamilyMembers().isEmpty()) {
			Customers cust = customersRepository.save(customer);
			
			List<FamilyMembers> listOfMember = new ArrayList<FamilyMembers>();
			
			for (FamilyMembers familyMembers: customer.getFamilyMembers()) {
				familyMembers.getCustomersId().setId(cust.getId());
				familyMembers = familyMembersRepository.save(familyMembers);
				listOfMember.add(familyMembers);
			}
			
			cust.setFamilyMembers(listOfMember);
			
			return cust;
			
		} else {
			return super.update(customer);
		}
	}
}
