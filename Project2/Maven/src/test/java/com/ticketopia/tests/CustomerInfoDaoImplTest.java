package com.ticketopia.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.daos.CustomerInfoDao;
import com.ticketopia.daos.CustomerInfoDaoImpl;

public class CustomerInfoDaoImplTest {
	@Mock
	static CustomerInfo ci;

	@Mock
	static CustomerInfoDao cid;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ci = mock(CustomerInfo.class);
		cid = (CustomerInfoDao) mock(CustomerInfoDaoImpl.class);
		when(cid.createCustomer(ci)).thenReturn(true);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ci = null;
		cid = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testCreateCustomer() {
		assertTrue(cid.createCustomer(ci));
	}

	@Test
	public final void testCreatePaymentMethod() {
	}

	@Test
	public final void testAdjustUserRole() {
	}

	@Test
	public final void testChangePassword() {
	}

	@Test
	public final void testRemovePaymentMethod() {
	}

	@Test
	public final void testApplyPoints() {
	}

}
