package com.bank.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bank.beans.CustomerDetails;
import com.bank.utility.Database;
public class RegistrationImplDAO implements IRegistrationDAO{
	
	
	public CustomerDetails registration(CustomerDetails cust) throws Exception {
		Database db =  new Database();
		 Connection con = db.getConnection();
		String  statement ="insert into customer_details values(acc_no.nextval,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(statement);
	//	pst.setLong(0, );
		pst.setString(1, cust.getFirstName());
		
		pst.setString(2, cust.getLastName());
		
		pst.setString(3, cust.getEmailId());
		
		pst.setString(4, cust.getPassword());
		
		pst.setLong(5, cust.getAadharNo());
		
		pst.setLong(6, cust.getPanCard());
		
		pst.setString(7, cust.getAddress());
		
		pst.setLong(8, cust.getMobileNo());
		
		pst.setInt(9, cust.getBalance());
		pst.executeUpdate();
		long aadhar = cust.getAadharNo();
		
		PreparedStatement st = con.prepareStatement("select acc_no from customer_details where aadhar_no=?");
		
		st.setLong(1, aadhar);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
		cust.setAccountNo(rs.getLong(1));
			}
		
		return cust;
		}

	public CustomerDetails login(long accNo, String pw) throws Exception {
		// checking the account number and password
		Database db1 =  new Database();
		 Connection con = db1.getConnection();
		int count =0;
		CustomerDetails obj  = new CustomerDetails();
		 PreparedStatement st = con.prepareStatement("select * from customer_details where acc_no=? and password = ?");
		 st.setLong(1, accNo);
		 st.setString(2, pw);
		 ResultSet rs = st.executeQuery();
		 while(rs.next()) {
			obj.setBalance(rs.getInt("balance"));
			obj.setAccountNo(rs.getLong(1));
		 count++;
		 }
		if(count==0)	
			return null;
		else return obj;

	}

}
