package com.sample.customersproducts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.customersproducts.model.Products;

@Controller
@RequestMapping("/products")
public class ProductsController extends AbstractController<Products, String> {
	
	@PostMapping("/getAllProducts")
	public String showAllProducts(Model model) {
		this.logInfo("getAllProducts", null);
		model.addAttribute("list", this.abstractService.findAll());
		return "getAllProducts";
	}
	
	@GetMapping("/add")
	public String addProducts() {
		this.logInfo("addProducts", null);
		return "addProducts";
	}
	
	@PostMapping("/save")
	public String saveProducts(@ModelAttribute Products products,
			Model model) {
		this.logInfo("saveProducts", null);
		this.add(products);
		String message = "Add successfully !";
		model.addAttribute("message", message);
		return "addProducts";
	}
	
	@GetMapping("/edit")
	public String getEditProducts(Model model,
			@RequestParam String id) {
		this.logInfo("getEditProducts", id);
		Products product = this.getById(id);
		model.addAttribute("product", product);
		return "updateProducts";
	}
	
	@PostMapping("/update")
	public String updateProducts(@ModelAttribute Products product,
			Model model) {
		this.logInfo("updateProducts", null);
		this.update(product);
		String message = "Update successfully !";
		model.addAttribute("message", message);
		model.addAttribute("product", product);
		return "updateProducts";
	}
}
