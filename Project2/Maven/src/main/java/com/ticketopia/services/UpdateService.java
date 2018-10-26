package com.ticketopia.services;

import java.util.List;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.PaymentInfo;
import com.ticketopia.beans.Ticket;
import com.ticketopia.beans.UserType;
import com.ticketopia.daos.CustomerInfoDao;
import com.ticketopia.daos.CustomerInfoDaoImpl;
import com.ticketopia.daos.PaymentInfoDao;
import com.ticketopia.daos.PaymentInfoDaoImpl;
import com.ticketopia.daos.UserTypeDao;
import com.ticketopia.daos.UserTypeDaoImpl;

public class UpdateService {
	//update email
	public static Boolean updateEmail(CustomerInfo customer, String email) {
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		customer.setUserEmail(email);
		return cid.updateCustomerInfo(customer);
	}
	
	//update payment
	public static Boolean updatePayment(PaymentInfo payment,
										Long cardNumber,
										Integer securityCode,
										String expirationDate,
										String billingAddress,
										String billingCity,
										String billingState,
										Integer billingZip) {
		PaymentInfoDao pid = new PaymentInfoDaoImpl();
		payment.setCardNumber(cardNumber);
		payment.setSecurityCode(securityCode);
		payment.setExpirationDate(expirationDate);
		payment.setBillingAddress(billingAddress);
		payment.setBillingCity(billingCity);
		payment.setBillingState(billingState);
		payment.setBillingZip(billingZip);
		
		return pid.updatePaymentInfo(payment);
	}
	
	//update points
	public static Boolean updatePoints(CustomerInfo customer, Ticket ticket, 
										Boolean smallDiscount, Boolean bigDiscount) {
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		UserType userType = customer.getRole();
		Double price = Math.floor(ticket.getTicketPrice());
		if (smallDiscount) {
			customer.setAccumulatedPoints(customer.getAccumulatedPoints()-5000);
		} else if (bigDiscount) {
			customer.setAccumulatedPoints(customer.getAccumulatedPoints()-10000);
		} else {
			if (userType.getRoleId() == 1) {
				customer.setAccumulatedPoints(customer.getAccumulatedPoints()+(int)(price*10));
			} else if (userType.getRoleId() == 2) {
				customer.setAccumulatedPoints(customer.getAccumulatedPoints()+(int)(price*25));
			}
			
		}
		return cid.updateCustomerInfo(customer);
	}
	
	//update role
	public static boolean updateRole(CustomerInfo customer, Integer roleId) {
		UserTypeDao utd = new UserTypeDaoImpl();
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		List<UserType> roles = utd.getUserTypes();
		UserType userType = null;
		
		for(UserType role: roles) {
			if (role.getRoleId() == roleId) {
				userType = role;
				break;
			}
		}
		
		customer.setRole(userType);
		
		return cid.updateCustomerInfo(customer);
	}
	
	//update address
	public static boolean updateAddress(CustomerInfo customer,
										String address,
										String city,
										String state,
										Integer zip) {
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		
		customer.setUserAddress(address);
		customer.setUserCity(city);
		customer.setUserState(state);
		customer.setUserZip(zip);
		
		return cid.updateCustomerInfo(customer);
	}
	
	//update password
	public static boolean updatePassword(CustomerInfo customer, String password) {
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		
		customer.setPassword(password);
		
		return cid.updateCustomerInfo(customer);
	}
	
	//update display name
	public static boolean updateDisplayName(CustomerInfo customer, String displayName) {
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		
		customer.setDisplayName(displayName);
		
		return cid.updateCustomerInfo(customer);
	}
	
	//update name
	public static boolean updateCustomerName(CustomerInfo customer, String fName, String lName) {
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		
		customer.setUserFName(fName);
		customer.setUserLName(lName);
		
		return cid.updateCustomerInfo(customer);
	}
	//update post
	//update ticket price
	//update post title
}
