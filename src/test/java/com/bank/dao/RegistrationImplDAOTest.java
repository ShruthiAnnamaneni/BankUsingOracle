package com.bank.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bank.beans.CustomerDetails;


class RegistrationImplDAOTest {
	
	@Test
	void testRegistration() throws Exception {
		RegistrationImplDAO dao = new RegistrationImplDAO();
		CustomerDetails cust = new CustomerDetails();
		cust.setFirstName("Keerthi");
		cust.setLastName("Rao");
		cust.setEmailId("keerthi@gmail.com");
		cust.setPassword("keerthi");
		cust.setAddress("warangal");
		cust.setAadharNo(987656734123L);
		cust.setPanCard(458910);
		cust.setMobileNo(7702680445L);
		cust.setBalance(8000);
		CustomerDetails cust1=dao.registration(cust);
		assertEquals(1000000008,cust1.getAccountNo());

	}

	@Test
	void testLogin() throws Exception {
		RegistrationImplDAO dao = new RegistrationImplDAO(); 
		CustomerDetails cust = dao.login(1000000000,"shruthi"); 
		int bal= cust.getBalance();
		assertEquals(6500,bal);
	}

}
