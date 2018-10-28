package com.ticketopia.daos;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ticketopia.beans.CustomerInfo;

public class CustomerDaoImplTest {
	private static CustomerInfoDao cid = new CustomerInfoDaoImpl();
	
	private static CustomerInfo customer = new CustomerInfo("bob.bobson@mafia.net", "Mafia Master", 
			"Bob", "Bobson", 98765432, 2, "100 Killer Rd", "Heart Broken Town", "MN", 999969,
			"password");
	private static CustomerInfo customer2 = new CustomerInfo("user@email.info", "displayName", "display", 
			"name", 0, 1, "12345 Street Blvd", "City", "State", 123456, "admin");

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@Test
	public void testGetCustomerByEmail() {
		CustomerInfo testCustomer = cid.getCustomerByEmail("bob.bobson@mafia.net");
		assertTrue(testCustomer.getAccumulatedPoints().equals(customer.getAccumulatedPoints()));
		assertTrue(testCustomer.getDisplayName().equals(customer.getDisplayName()));
		assertTrue(testCustomer.getPassword().equals(customer.getPassword()));
		assertTrue(testCustomer.getRole().equals(customer.getRole()));
		assertTrue(testCustomer.getUserAddress().equals(customer.getUserAddress()));
		assertTrue(testCustomer.getUserCity().equals(customer.getUserCity()));
		assertTrue(testCustomer.getUserEmail().equals(customer.getUserEmail()));
		assertTrue(testCustomer.getUserFName().equals(customer.getUserFName()));
		assertTrue(testCustomer.getUserLName().equals(customer.getUserLName()));
		assertTrue(testCustomer.getUserState().equals(customer.getUserState()));
		assertTrue(testCustomer.getUserZip().equals(customer.getUserZip()));
	}
	
	@Test
	public void testCreateCustomer() {
		assertTrue(cid.createCustomer(customer2));
	}

}