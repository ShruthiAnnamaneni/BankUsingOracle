package com.bank.dao;
public interface ITransactionDAO {
	
	public int withdraw (int amt,long account_no) throws Exception;
	public int deposit (int amt, long account_no) throws Exception;
	public int fundTransfer(long toAccNo, long fromAccNo, int amt) throws Exception;
	public int showBal(long accNo) throws Exception;

}
