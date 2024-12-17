package com.sample.customersproducts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.customersproducts.model.Customers;

@Controller
@RequestMapping("/customers")
public class CustomersController extends AbstractController<Customers, String> {
	
	@PostMapping("/getAllCustomers")
	public String showAllCustomers(Model model) {
		this.logInfo("showAllCustomers", null);
		model.addAttribute("list", this.abstractService.findAll());
		return "getAllCustomers";
	}
	
	@GetMapping("/add")
	public String addCustomers() {
		this.logInfo("addCustomers", null);
		return "addCustomers";
	}
	
	@PostMapping("/save")
	public String saveCustomers(@ModelAttribute Customers customers,
			Model model) {
		this.logInfo("saveCustomers", null);
		this.add(customers);
		String message = "Add successfully !";
		model.addAttribute("message", message);
		return "addCustomers";
	}
	
	@GetMapping("/edit")
	public String getEditCustomers(Model model,
			@RequestParam String id) {
		this.logInfo("getEditCustomers", id);
		Customers customer = this.getById(id);
		model.addAttribute("customer", customer);
		return "updateCustomers";
	}
	
	@PostMapping("/update")
	public String updateCustomers(@ModelAttribute Customers customer,
			Model model) {
		this.logInfo("updateCustomers", null);
		this.update(customer);
		String message = "Update successfully !";
		model.addAttribute("message", message);
		model.addAttribute("customer", customer);
		return "updateCustomers";
	}
}
