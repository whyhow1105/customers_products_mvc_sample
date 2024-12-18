package com.sample.customersproducts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sample.customersproducts.model.FamilyMembers;

@Repository
public interface FamilyMembersRepository extends AbstractRepository<FamilyMembers, String> {
	
	@Query("SELECT fm FROM FamilyMembers fm WHERE fm.customersId.id = :customersId")
	List<FamilyMembers> findAllByCustomersId(String customersId);

}
