package com.aditya.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name = "customer")
public class CustomerEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;
    
    @Column(name = "customer_name")
    private String customerName;
    
    @Column(name = "bill_number")
    private Integer bill;
    
    @Column(name = "customer_address")
    private String address;
    
    @Column(name = "gender")
    private String gender;
    
    
    @Override
	public String toString() {
		return "CustomerEntity [customerId=" + customerId + ", customerName=" + customerName + ", bill=" + bill
				+ ", address=" + address + ", gender=" + gender + ", customerType=" + customerType + "]";
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getBill() {
		return bill;
	}

	public void setBill(Integer bill) {
		this.bill = bill;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public CustomerEntity(Integer customerId, String customerName, Integer bill, String address, String gender,
			String customerType) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.bill = bill;
		this.address = address;
		this.gender = gender;
		this.customerType = customerType;
	}

	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name = "customer_type")
    private String customerType;

 

    
    
	
 

    
    
}