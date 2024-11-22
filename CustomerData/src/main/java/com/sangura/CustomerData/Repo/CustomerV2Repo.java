package com.sangura.CustomerData.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sangura.CustomerData.Entity.CustomerV2;

public interface CustomerV2Repo extends JpaRepository<CustomerV2, Integer>{

}
