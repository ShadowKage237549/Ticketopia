package com.ticketopia.daos;

import java.util.List;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.UserType;

public interface CustomerInfoDao {
	public boolean createCustomer(CustomerInfo customer);
	public List<CustomerInfo> getCustomerInfo();
	public Boolean removeCustomerInfo(CustomerInfo customer);
	public CustomerInfo getCustomerByEmail(String email);
	public boolean updateCustomerInfo(CustomerInfo customer, String email);
}
