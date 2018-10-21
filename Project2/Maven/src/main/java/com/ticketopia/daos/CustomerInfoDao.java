package com.ticketopia.daos;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.PaymentInfo;
import com.ticketopia.beans.UserType;

public interface CustomerInfoDao {
	// create account
			// takes in:
				// display name
				// first name
				// last name
				// address
				// email
				// password
			// adds this to database
	public boolean createCustomer(CustomerInfo customer);
		
		// add payment method
			// takes in:
				// email
				// card number
				// security code
				// expiration
				// billing address
			//adds this to database
	public boolean createPaymentMethod(PaymentInfo payment);
		
		// adjust role
			// takes in email and desired role
			// if upgrading, make sure there is payment info on file
			// if downgrading, simply adjust role
	public boolean adjustUserRole(CustomerInfo customer, Integer newRole);
		
		// change password
			// verify password first
			// save new password to the database
	public boolean changePassword(CustomerInfo customer, String newPassword);
		
		// remove payment method
			// if premium user, must downgrade
			// removes payment method from database
	public boolean removePaymentMethod(PaymentInfo payment);
	
	// apply points
		// should take in the price of the ticket
		// apply points to users account
	public void applyPoints(CustomerInfo customer, Integer points);
}
