package com.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.beans.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
