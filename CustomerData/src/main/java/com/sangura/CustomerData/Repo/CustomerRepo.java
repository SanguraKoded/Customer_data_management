package com.sangura.CustomerData.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sangura.CustomerData.Entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
