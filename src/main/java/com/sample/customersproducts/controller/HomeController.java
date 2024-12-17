package com.sample.customersproducts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sample.customersproducts.common.Logging;

@Controller
public class HomeController extends Logging {

	@GetMapping("/")
	public String showHomePage() {
		this.logInfo("showHomePage", null);
		return "index";
	}
}
