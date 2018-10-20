package com.ticketopia.daos;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.UserRole;

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
	public boolean createPaymentMethod(String email, 
								Integer cardNumber,
								Integer securityCode,
								String expirationDate,
								String billingAddress,
								String billingCity,
								String billingState,
								Integer billingZip);
		
		// adjust role
			// takes in email and desired role
			// if upgrading, make sure there is payment info on file
			// if downgrading, simply adjust role
	public boolean adjustUserRole(String email, UserRole role);
		
		// change password
			// verify password first
			// save new password to the database
	public boolean changePassword(String email, String oldPassword);
		
		// remove payment method
			// if premium user, must downgrade
			// removes payment method from database
	public boolean removePaymentMethod(String email, UserRole role);
	
	// apply points
		// should take in the price of the ticket
		// apply points to users account
	public void applyPoints(Double points);
}
