package com.bank.service;
import com.bank.beans.CustomerDetails;

public interface IRegistrationService {
	
	public CustomerDetails registration(CustomerDetails cust) throws Exception;
	
	public CustomerDetails login (long accNo,String pw) throws Exception;
	
}
