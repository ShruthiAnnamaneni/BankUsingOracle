package com.bank.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bank.beans.TransactionDetails;

class TransacImplDAOTest {

	@Test
	void testWithdraw() throws Exception {
	TransacImplDAO trans=new TransacImplDAO();
	TransactionDetails transfer=new TransactionDetails();
	int amount =trans.withdraw(2000,1000000006);

	assertEquals(8000,amount);
	
	}

	@Test
	void testDeposit() throws Exception {
	TransacImplDAO trans=new TransacImplDAO();
	int ret1=trans.deposit(1000,1000000006);
	assertEquals(9000,ret1);

	}

	@Test
	void testFundTransfer() throws Exception {
	TransacImplDAO trans=new TransacImplDAO();
	TransactionDetails transfer=new TransactionDetails();
	int cust2=trans.fundTransfer( 1000000001, 1000000006, 20000);
	assertEquals(0,cust2);

	}

	@Test
	void testShowBalance() throws Exception{
		TransacImplDAO trans=new TransacImplDAO();
	int bal = trans.showBal(1000000006);
	assertEquals(10000,bal);

	}

}
