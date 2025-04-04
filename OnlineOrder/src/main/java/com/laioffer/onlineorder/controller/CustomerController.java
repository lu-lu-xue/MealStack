package com.laioffer.onlineorder.controller;

import com.laioffer.onlineorder.model.RegisterBody;
import com.laioffer.onlineorder.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luluxue
 * @date 2024-10-12 10:36AM
 */
@RestController
public class CustomerController {
	
	
	private final CustomerService customerService;
	
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService; // dependency
	}
	
	
	@PostMapping("/signup") // the first step to sign up, then you can login
	@ResponseStatus(value = HttpStatus.CREATED) // response status
	public void signUp(@RequestBody RegisterBody body) {
		customerService.signUp(body.email(), body.password(), body.firstName(), body.lastName());
	}
}

