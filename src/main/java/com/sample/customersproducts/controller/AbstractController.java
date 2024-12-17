package com.sample.customersproducts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sample.customersproducts.common.Logging;
import com.sample.customersproducts.data.service.AbstractService;

public abstract class AbstractController<T, ID> extends Logging {
	
	@Autowired
	AbstractService<T, ID> abstractService;
	
	@GetMapping("/{id}")
	public T getById(@PathVariable ID id) {
		this.logInfo("getById", (String) id);
		return abstractService.getById(id);
	}
	
	@PostMapping
	public T add(@RequestBody T obj) {
		this.logInfo("add", null);
		return abstractService.add(obj);
	}
	
	@PutMapping
	public T update(@RequestBody T obj) {
		this.logInfo("update", null);
		return abstractService.update(obj);
	}

}
