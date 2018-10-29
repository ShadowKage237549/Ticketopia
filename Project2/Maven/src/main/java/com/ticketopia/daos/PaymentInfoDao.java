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
	public List<PaymentInfo> getPayments();
	public boolean updatePaymentInfo(PaymentInfo payment);
	public PaymentInfo getPaymentByEmail(String email);
}
