package com.aditya.cms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.cms.businessbean.Customer;
import com.aditya.cms.service.CustomerServiceImpl;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	@GetMapping("/")
	public String home() {
		return("<h1>Customer Management System</h1>");
	}
	
	@RequestMapping(value = "/cust/controller/getCustById/{id}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomerDetailsById(@PathVariable("id") int myId){
		Customer customer = customerService.getCustomerDetailsById(myId);
		
		if(customer!=null) {
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}else {
			return new ResponseEntity<Customer>(customer, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/cust/controller/addCust", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
		int id = customerService.addCustomer(customer);
		System.out.println("[id]:"+id);
		return new ResponseEntity<String>("Customer added successfully with id: "+id, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/cust/controller/deleteCustById/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable("id") int myId){
		Customer customer = customerService.deleteCustomerbyId(myId);
		if(customer == null) {
			return new ResponseEntity<Customer>(customer, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println("Deleted: "+customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		
	}
	
	@RequestMapping(value= "cust/controller/updateCust",
					method = RequestMethod.PUT,
					consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		Customer customerBean = customerService.updateCustomer(customer);
		if(customerBean == null) {
			return new ResponseEntity<Customer>(customerBean, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println(customer);
		return new ResponseEntity<Customer>(customerBean, HttpStatus.OK);
	}
}
