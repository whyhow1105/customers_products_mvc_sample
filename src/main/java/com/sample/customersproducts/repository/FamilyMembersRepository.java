package com.sample.customersproducts.repository;

import org.springframework.stereotype.Repository;

import com.sample.customersproducts.model.FamilyMembers;

@Repository
public interface FamilyMembersRepository extends AbstractRepository<FamilyMembers, String> {

}
