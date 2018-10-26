package com.ticketopia.daos;

import java.util.List;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.PaymentInfo;

public interface PaymentInfoDao {
	
	//Insert a new payment info bean into the database
	public boolean insertNewPaymentInfo(PaymentInfo paymentInfo);
	//Remove a payment info bean from the database
	public boolean removePaymentInfo(PaymentInfo paymentInfo);
	//Update a payment info bean in the database.
	public boolean updatePaymentEmail(PaymentInfo payment, CustomerInfo customer);
	public boolean updatePaymentCardNumber(PaymentInfo paymentInfo, Long cardNumber);
	public boolean updatePaymentSecurityCode(PaymentInfo paymentInfo, Integer securityCode);
	public boolean updatePaymentExpirationDate(PaymentInfo paymentInfo, String expirationDate);
	public boolean updatePaymentBillingAddress(PaymentInfo paymentInfo, String address,
			String city, String state, Integer zip);
	public List<PaymentInfo> getPayments();
}
