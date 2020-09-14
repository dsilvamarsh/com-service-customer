package com.tutorial.controller;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.beans.Customer;
import com.tutorial.repository.CustomerRepo;


@RestController
public class CustomerController {
	
	private static final Logger log = LogManager.getLogger(CustomerController.class.getName());
	
	@Autowired
	private CustomerRepo repo = null;
	
	public CustomerController() {
		
	}
	
	
	@GetMapping("/customer/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		log.debug("Fetch Customer for id:"+id);
		return repo.findById(id).get();
	}
	@Transactional(isolation = Isolation.SERIALIZABLE)
	@PostMapping("/customer")
	public void createCustomer(@RequestBody Customer customer) {
		log.debug("Before customer saved operation"+customer.getFirstName());
		repo.save(customer);
		log.debug("after customer save opeartion"+repo.existsById(customer.getId()));
	}
	

}
