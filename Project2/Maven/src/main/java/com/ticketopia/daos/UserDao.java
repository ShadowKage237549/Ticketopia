package com.ticketopia.daos;

import com.ticketopia.beans.UserRoles;

public interface UserDao {
	// create account
			// takes in:
				// display name
				// first name
				// last name
				// address
				// email
				// password
			// adds this to database
	public boolean createUser(String email, 
						String displayName, 
						String fName, 
						String lName, 
						String address,
						String city,
						String state,
						Integer zip,
						String password);
		
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
	public boolean adjustUserRole(String email, UserRoles role);
		
		// change password
			// verify password first
			// save new password to the database
	public boolean changePassword(String email, String oldPassword);
		
		// remove payment method
			// if premium user, must downgrade
			// removes payment method from database
	public boolean removePaymentMethod(String email, UserRoles role);
}
