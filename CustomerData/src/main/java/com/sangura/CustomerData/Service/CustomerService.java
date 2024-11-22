package com.sangura.CustomerData.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangura.CustomerData.Entity.Customer;
import com.sangura.CustomerData.Entity.CustomerV1;
import com.sangura.CustomerData.Entity.CustomerV2;
import com.sangura.CustomerData.Exceptions.InvalidCustomerIdException;
import com.sangura.CustomerData.Exceptions.InvalidEmailException;
import com.sangura.CustomerData.Repo.CustomerRepo;
import com.sangura.CustomerData.Repo.CustomerV1Repo;
import com.sangura.CustomerData.Repo.CustomerV2Repo;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	CustomerV1Repo customerV1Repo;
	
	@Autowired
	CustomerV2Repo customerV2Repo;
	
	public List<Customer> getAllCustomers(){
		return customerRepo.findAll();
	}
	
	public Customer getCustomerById(int id) {
		
		try {
			Customer customer = customerRepo.findById(id).orElseThrow(() -> new InvalidCustomerIdException("Given Customer Id is invalid"));
			return customer;
		}
		catch(IllegalArgumentException e) {
			System.out.println("Unexpected Error Occured " +e.getMessage());
			return null;
		}
	}
	
	public Customer updateCustomerById(int id, Customer customer) {
		try {
			customerRepo.findById(id).orElseThrow(() -> new InvalidCustomerIdException ("Given Customer Id is Invalid"));
			return customerRepo.save(customer);
		}
		catch(IllegalArgumentException e) {
			System.out.println("Unexpected Error Occured "+e.getMessage());
			return null;
		}

	}
	
	public Customer createCustomer(Customer customer) {
		if(!customer.getEmail().endsWith("@gmail.com")|| !customer.getEmail().endsWith("@outlook.com")) {
			 throw new InvalidEmailException ("Enter valid Customer email");
		}
		return customerRepo.save(customer);
	}

	public String deleteCustomerById(int id) {
		try {
			customerRepo.findById(id).orElseThrow(() -> new InvalidCustomerIdException("Given Customer Id is invalid"));
			return ("The Customer with Id"+ id+" is successfully deleted");
		}
		catch(IllegalArgumentException e) {
			System.out.println("Unexpected Error Occured "+e.getMessage());
			return null;
		}
	}
	
	public List<CustomerV1> getAllCustomerV1(){
		return customerV1Repo.findAll();
	}
	
	public CustomerV1 getCustomerV1ById(int id) {
		try {
			return customerV1Repo.findById(id).orElseThrow(() -> new InvalidCustomerIdException("Given Customer Id is invalid"));
		}
		catch(IllegalArgumentException e) {
			System.out.println("Unexpected Error Occured "+e.getMessage());
			return null;
		}
	}
	
	public List<CustomerV2> getAllCustomerV2(){
		return customerV2Repo.findAll();
	}
	
	public CustomerV2 getCustomerV2ById(int id) {
		try {
			return customerV2Repo.findById(id).orElseThrow(() -> new InvalidCustomerIdException("Given Customer Id is invalid"));
		}
		catch(IllegalArgumentException e) {
			System.out.println("Unexpected Error Occured "+e.getMessage());
			return null;
		}
	}
	
	
}
