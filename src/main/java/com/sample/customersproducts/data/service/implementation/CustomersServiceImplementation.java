package com.sample.customersproducts.data.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		
		String customersId = customer.getId();
		
		List<FamilyMembers> list = familyMembersRepository.findAllByCustomersId(customersId);
		
		List<FamilyMembers> listOfMember = customer.getFamilyMembers();
		
 		if (null != listOfMember && !listOfMember.isEmpty()) {
			
 			if (null != list && !list.isEmpty()) {
 				
 				List<String> currentFamilyMembersId = listOfMember.stream()
 						.map(e -> e.getId())
 						.collect(Collectors.toList());
 				
 				List<String> familyMembersIds = list.stream()
 						.filter(e -> !currentFamilyMembersId.contains(e.getId()))
 						.map(f -> f.getId())
 						.collect(Collectors.toList());
 				
 				if (null != familyMembersIds && !familyMembersIds.isEmpty()) {
 					familyMembersRepository.deleteAllById(familyMembersIds);
 				}
			}
 			
 			System.out.println(listOfMember.size());
 			
 			List<FamilyMembers> listOfFamilyMember = new ArrayList<FamilyMembers>();
			
			for (FamilyMembers familyMembers: listOfMember) {
				if (null == familyMembers.getCustomersId()) {
					familyMembers.getCustomersId().setId(customersId);
				}
				familyMembers = familyMembersRepository.save(familyMembers);
				listOfFamilyMember.add(familyMembers);
			}
			
			customer.setFamilyMembers(listOfFamilyMember);
			
			return customersRepository.save(customer);
			
		} else {
			
			if (null != list && !list.isEmpty()) {
				List<String> currentFamilyMembersId = list.stream()
 						.map(e -> e.getId())
 						.collect(Collectors.toList());
				
				familyMembersRepository.deleteAllById(currentFamilyMembersId);
			}
			
			return super.update(customer);
		}
	}
}
