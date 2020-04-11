package com.swanoff.springdemo.dao;

import java.util.List;

import com.swanoff.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
}
