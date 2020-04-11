package com.swanoff.springdemo.service;

import java.util.List;

import com.swanoff.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
