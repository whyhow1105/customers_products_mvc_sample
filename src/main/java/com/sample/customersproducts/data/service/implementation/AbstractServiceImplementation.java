package com.sample.customersproducts.data.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import com.sample.customersproducts.common.Logging;
import com.sample.customersproducts.data.service.AbstractService;
import com.sample.customersproducts.repository.AbstractRepository;

public class AbstractServiceImplementation<T, ID> extends Logging implements AbstractService<T, ID> {

	@Autowired
	AbstractRepository<T, ID> abstractRepository;

	@Override
	public T getById(ID id) {
		this.logInfo("getById", (String) id);
		Optional<T> obj = abstractRepository.findById(id);
		return obj.isPresent() ? obj.get() : null;
	}

	@Override
	public T add(T obj) {
		this.logInfo("add", null);
		return abstractRepository.save(obj);
	}

	@Override
	public T update(T obj) {
		this.logInfo("update", null);
		return abstractRepository.save(obj);
	}

	@Override
	public List<T> findAll() {
		this.logInfo("findAll", null);
		return StreamSupport.stream(abstractRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	
}
