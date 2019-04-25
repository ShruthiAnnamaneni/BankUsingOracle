package com.bank.service;
import com.bank.beans.*;
import com.bank.dao.*;


public class RegistrationServiceImpl implements IRegistrationService {

	IRegistrationDAO registerDao = new RegistrationImplDAO();
	
	public CustomerDetails registration(CustomerDetails cust) throws Exception {
		
		return registerDao.registration(cust);
	}

	public CustomerDetails login(long accNo,String pw) throws Exception {

		CustomerDetails obj1 = registerDao.login(accNo, pw);
		
		return obj1;
	}

	
}
