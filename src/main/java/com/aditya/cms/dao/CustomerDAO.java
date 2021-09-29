package com.aditya.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aditya.cms.entity.CustomerEntity;
@Repository
public interface CustomerDAO extends JpaRepository<CustomerEntity, Integer> {

}
