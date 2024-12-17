package com.sample.customersproducts.repository;

import org.springframework.stereotype.Repository;

import com.sample.customersproducts.model.Products;

@Repository
public interface ProductsRepository extends AbstractRepository<Products, String> {

}
