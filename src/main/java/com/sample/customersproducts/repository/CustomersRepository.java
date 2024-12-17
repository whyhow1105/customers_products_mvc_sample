package com.sample.customersproducts.repository;

import org.springframework.stereotype.Repository;

import com.sample.customersproducts.model.Customers;

@Repository
public interface CustomersRepository extends AbstractRepository<Customers, String> {

}
