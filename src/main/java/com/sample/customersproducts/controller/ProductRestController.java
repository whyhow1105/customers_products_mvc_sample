package com.sample.customersproducts.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.customersproducts.model.Products;

@RestController
@RequestMapping("/product")
public class ProductRestController extends AbstractController<Products, String> {
	

}
