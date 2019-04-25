package com.bank.ui;
import com.bank.beans.CustomerDetails;
import com.bank.exceptions.AadharCheck;
import com.bank.exceptions.MobileCheck;
import com.bank.service.*;
import java.util.Scanner;

public class MainClass {
	static Scanner input =  new Scanner(System.in);
	static IRegistrationService service = new RegistrationServiceImpl();
	static TransacServiceImpl ser = new TransacServiceImpl();

	public static CustomerDetails setInfo() throws Exception{
		CustomerDetails entry  = new CustomerDetails();
		System.out.println("Enter First Name");
		entry.setFirstName(input.next());
		System.out.println("Enter the last Name");
		entry.setLastName(input.next());
		System.out.println("Enter the email id");
		entry.setEmailId(input.next());
		System.out.println("Enter the password for account");
		entry.setPassword(input.next());
		System.out.println("Enter the pan card number");
		entry.setPanCard(input.nextLong());
		System.out.println("Enter the aadhar card number");
		long aadhar = input.nextLong();
		boolean aadharCheck =ser.checkAadhar(aadhar);
		if(aadharCheck)
		entry.setAadharNo(aadhar);
		else {
			throw new AadharCheck();
			
		}
		System.out.println("Enter the address");
		entry.setAddress(input.next());
		System.out.println("Enter the mobile number");
		long mob = input.nextLong();
		boolean mobCheck = ser.checkMobile(mob);
		if(mobCheck)
		entry.setMobileNo(mob);
		else {
			throw new MobileCheck();
		}
		entry.setBalance(0);

		CustomerDetails cust = service.registration(entry);
		return cust;
	}
	
	
	
	public static void main(String[] args) throws Exception {
		int choose;
		ITransacService serv = new TransacServiceImpl();
		CustomerDetails obj1 =  null;
		while(true) {
		System.out.println("Enter \n1.Registration \n2.Login \n3.Exit");	
		choose = input.nextInt();
		switch(choose) {
		
		case 1:	//Registration 
						obj1  = setInfo();
						System.out.println("Your account number is "+obj1.getAccountNo());
						break;
		
		case 2:	//Login	
					int ch;
					System.out.println("Enter the acc no");
						long accNo = input.nextLong();
						System.out.println("enter the password");
						String pw = input.next();
						CustomerDetails obj2 = service.login(accNo,pw);	
						if(obj2!=null) {
						while(true) {
							System.out.println("1.Withdraw \n2.Deposit \n3.Fund Transfer \n4.View balance \n5.Exit");
							ch  = input.nextInt();
							
								switch(ch) {
							
							case 1:		System.out.println("enter the account number ");
										long acc = input.nextLong();
											System.out.println("Enter the amount to withdraw");
											if(accNo!=acc) {
												System.err.println("account number mismatch");
												System.exit(0);
											}
											int withdrawAmt = input.nextInt();
											int withdraw = serv.withdraw(withdrawAmt,acc);
											if(withdraw==0)
												System.out.println("wrong account number");
											else if(withdraw==2){
											System.out.println("Low balance in your account");
											}
											else {
							System.out.println(" after withdraw your account balance is "+withdraw);	
											}	break;
							case 2:	System.out.println("enter the account number ");
									long acc1 = input.nextLong();
									if(accNo!=acc1) {
										System.err.println("account number mismatch");
										System.exit(0);
									}

									
									System.out.println("Enter the amount to deposit");
									int depositAmt = input.nextInt();
									int deposit = serv.deposit(depositAmt, acc1);
									if(deposit==0)
										System.out.println("wrong account number");
									else
										System.out.println(" your account balance after deposit is "+deposit);	
									break;
							
							case 3: System.out.println("Enter account number of receiver");
									long to = input.nextLong();
							//	System.out.println("enter account number of sender");
							long from = obj2.getAccountNo();
									System.out.println("enter the amount to send");
							int amt =  input.nextInt();
									int fundTransfers = serv.fundTransfer(to,from,amt);
									if(fundTransfers==0)
										System.out.println("low balance ");
									else
										System.out.println("amount transfered is "+amt+" available balance is "+serv.showBal(accNo));
										break;
							case 4: System.out.println(" your balance is "+serv.showBal(accNo));			
									break;
							case 5: //Exit
								System.exit(0);				
								}
							}
						}
						
						else
							System.out.println("wrong user name and password");
						
						
						break;
		
						case 3: //Exit
									System.exit(0);				
			
		}
		}
	}

}
