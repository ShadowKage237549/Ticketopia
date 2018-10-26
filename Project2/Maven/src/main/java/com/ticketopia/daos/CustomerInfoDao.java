package com.ticketopia.daos;

import java.util.List;

import com.ticketopia.beans.CustomerInfo;

public interface CustomerInfoDao {
	public boolean createCustomer(CustomerInfo customer);
	public boolean updateCustomerInfo(CustomerInfo customerInfo);
	public List<CustomerInfo> getCustomerInfo();
	public Boolean removeCustomerInfo(CustomerInfo customer);
	public CustomerInfo getCustomerByEmail(String email);
}
