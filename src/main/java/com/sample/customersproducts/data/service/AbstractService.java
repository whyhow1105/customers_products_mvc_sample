package com.sample.customersproducts.data.service;

import java.util.List;

public interface AbstractService<T, ID> {
	
	T getById(ID id);
	
	T add(T obj);
	
	T update(T obj);
	
	List<T> findAll();

}
