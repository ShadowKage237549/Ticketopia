package com.ticketopia.daos;

import java.util.List;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.UserType;

public interface CustomerInfoDao {
	public boolean createCustomer(CustomerInfo customer);
	public boolean updateCustomerEmail(CustomerInfo customerInfo, String email);
	public boolean updateCustomerDisplayName(CustomerInfo customerInfo, String displayName);
	public boolean updateCustomerFName(CustomerInfo customerInfo, String fName);
	public boolean updateCustomerLName(CustomerInfo customerInfo, String lName);
	public boolean updateCustomerAccumulatedPoints(CustomerInfo customerInfo, Integer points);
	public boolean updateCustomerUserType(CustomerInfo customerInfo, UserType userType);
	public boolean updateCustomerAddress(CustomerInfo customerInfo, String address,
			String city, String state, Integer zip);
	public boolean updateCustomerPassword(CustomerInfo customerInfo, String password);
	public Boolean removeCustomerInfo(CustomerInfo customer);
	public CustomerInfo getCustomerByEmail(String email);
}
