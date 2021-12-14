package com.aditya.cms.service;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditya.cms.businessbean.Customer;
import com.aditya.cms.dao.CustomerDAO;
import com.aditya.cms.entity.CustomerEntity;

@Service
public class CustomerServiceImpl {
		@Autowired
		private CustomerDAO customerDAO;
		
		public Integer addCustomer(Customer customer) {
			
			CustomerEntity customerEntity = new CustomerEntity();
			BeanUtils.copyProperties(customer, customerEntity);
			CustomerEntity cusEntity = (CustomerEntity)customerDAO.save(customerEntity);
			return cusEntity.getCustomerId();
		}
		public Customer getCustomerDetailsById(int customerId) {
			Customer customer = null;
			CustomerEntity customerEntity = customerDAO.getById(customerId);
			if(customerEntity != null) {
				customer = new Customer();
				BeanUtils.copyProperties(customerEntity, customer);
			}
			return customer;
		}
		public Customer deleteCustomerbyId(int customerId) {
			Customer customer = null;
			CustomerEntity customerEntity = customerDAO.getById(customerId);
			if(customerEntity != null) {
				customerDAO.deleteById(customerId);
				customer = new Customer();
				BeanUtils.copyProperties(customerEntity, customer);
			}
			return customer;
		}
		public Customer updateCustomer(Customer customer) {
			Customer customerBean = null;
			CustomerEntity customerEntity = customerDAO.getById(customer.getCustomerId());
			if(customerEntity != null) {
				//update ops
				BeanUtils.copyProperties(customer, customerEntity);
				customerDAO.save(customerEntity);
			}
			customerBean = new Customer();
			BeanUtils.copyProperties(customerEntity, customerBean);
			return customerBean;
			
		}
		
}
