package com.sample.customersproducts.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.customersproducts.model.Customers;

@RestController
@RequestMapping("/customer")
public class CustomerRestController extends AbstractController<Customers, String> {

}
