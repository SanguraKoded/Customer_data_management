package com.sangura.CustomerData.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangura.CustomerData.Entity.Customer;
import com.sangura.CustomerData.Entity.CustomerV1;
import com.sangura.CustomerData.Entity.CustomerV2;
import com.sangura.CustomerData.Service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
		
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customers = customerService.getAllCustomers();
		return ResponseEntity.ok(customers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id){
		Customer customer = customerService.getCustomerById(id);
		return ResponseEntity.ok(customer);
	}
	
	@GetMapping(value="/v1", headers="version=1")
	public ResponseEntity<List<CustomerV1>> getCustomersV1(){
		return ResponseEntity.ok(customerService.getAllCustomerV1());
	}
	
	@GetMapping(value="/v1/{id}", headers="version=1")
	public ResponseEntity<CustomerV1> getCustomerV1byId(int id){
		CustomerV1 customerV1 = customerService.getCustomerV1ById(id);
		return ResponseEntity.ok(customerV1);
	}
	
	@GetMapping(value="/v2", headers="version=2")
	public ResponseEntity<List<CustomerV2>> getAllCustomerV2(){
		return ResponseEntity.ok(customerService.getAllCustomerV2());
	}
	
	@GetMapping(value="v2/{id}", headers="version=2")
	public ResponseEntity<CustomerV2> getCustomerV2ById(int id){
		return ResponseEntity.ok(customerService.getCustomerV2ById(id));
	}
	
	@PostMapping("/add")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customer));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customer){
		Customer savedCustomer = customerService.updateCustomerById(id, customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id){
		customerService.deleteCustomerById(id);
		return ResponseEntity.noContent().build();
	}

}
