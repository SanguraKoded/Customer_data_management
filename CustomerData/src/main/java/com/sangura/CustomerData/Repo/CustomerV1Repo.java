package com.sangura.CustomerData.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sangura.CustomerData.Entity.CustomerV1;

public interface CustomerV1Repo extends JpaRepository<CustomerV1, Integer>{

}
