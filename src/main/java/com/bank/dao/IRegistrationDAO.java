package com.bank.dao;

import com.bank.beans.*;

public interface IRegistrationDAO {

public CustomerDetails registration(CustomerDetails cust) throws Exception;
	
	public CustomerDetails login (long accNo,String pw) throws Exception;
	
	
}
