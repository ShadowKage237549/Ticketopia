package com.ticketopia.daos;

import com.ticketopia.beans.PaymentInfo;

public interface PaymentInfoDao {
	
	//Insert a new payment info bean into the database
	public boolean insertNewPaymentInfo(PaymentInfo paymentInfo);
	//Remove a payment info bean from the database
	public boolean removePaymentInfoById(PaymentInfo paymentInfo, Integer id);
	//Update a payment info bean in the database.
	public boolean updatePaymentInfo(PaymentInfo paymentInfo);
}
