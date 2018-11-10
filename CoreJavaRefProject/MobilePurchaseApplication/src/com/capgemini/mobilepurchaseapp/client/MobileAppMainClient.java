package com.capgemini.mobilepurchaseapp.client;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.mobilepurchaseapp.bean.Mobile;
import com.capgemini.mobilepurchaseapp.bean.PurchaseDetails;
import com.capgemini.mobilepurchaseapp.dao.IMobileAppDAO;
import com.capgemini.mobilepurchaseapp.dao.MobileAppDaoImpl;
import com.capgemini.mobilepurchaseapp.service.IMobileService;
import com.capgemini.mobilepurchaseapp.service.MobileServiceImpl;
import com.capgemini.mobilepurchaseapp.exception.MobileException;



public class MobileAppMainClient {
	
	public static void main(String[] args) throws MobileException, SQLException {
		
	PropertyConfigurator.configure("resources/log4j.properties");
	Logger mobileAppLogger = Logger.getLogger(MobileAppMainClient.class.getName());

	Scanner sc = new Scanner(System.in);
	IMobileService mobileService = new MobileServiceImpl();
	IMobileAppDAO mobileDao = new MobileAppDaoImpl();
	//Validation data = new Validation();
	PurchaseDetails purchase = new PurchaseDetails();
	
	do {
		System.out.println("Welcome to Mobile Purchase Application...\n");
		System.out.println("Please Select option from given Menus");
		System.out.println("1. Insert New Mobile Information");
		System.out.println("2. Search Mobiles in a perticular price range");
		System.out.println("3. List all available Mobiles");
		System.out.println("4. Delete a perticular mobile information");
		System.out.println("5. Add Customer Purchase Details");
		System.out.println("6. Exit");
		System.out.println("\nPlease enter your choice: ");
		int choice = sc.nextInt();
		switch (choice) 
		{		
		
		case 1:
			System.out.println("Enter Mobile Name:");
			String name = sc.next();
			System.out.println("Enter Price :");
			float price = sc.nextFloat();
			System.out.println("Enter Quantity :");
			int quantity = sc.nextInt();

			Mobile mobile = new Mobile();
			mobile.setMobileName(name);
			mobile.setMobilePrice(price);
			mobile.setMobileQty(quantity);
			try {
				int mid = mobileService.insertMobileInfo(mobile);
				System.out.println("Information inserted for: "+ mid + " mobile");
				} catch (MobileException e) {
				System.out.println(e.getMessage());
				}
			break;
			
		
		

		case 2:
			System.out.println("Enter min price value for mobile search: ");
			int startval= sc.nextInt();
			System.out.println("Enter max price value for mobile search: ");
			int highval = sc.nextInt();

			try {
				List<Mobile> clist = mobileService.searchMobile(startval, highval);
				if (clist.size() != 0) {
					for (Mobile c : clist) 
					{
						System.out.println(c);
					}
				} else {
					System.out.println("No Mobiles are not available in given range.");
				}
			} catch (MobileException e) {
				System.out.println(e.getMessage());
			}
			break;
			
			
	case 3:
		try {
			List<Mobile> clist = mobileService.getAllMobilesInfo();
			if (clist.size() != 0) {
				for (Mobile c : clist) 
				{
					System.out.println(c);
				}
			} else {
				System.out.println("Mobiles are not available.");
			}
		} catch (MobileException e) {
			System.out.println(e.getMessage());
		}
		break;
	
	case 4:
		System.out.println("Enter Mobile ID to delete: ");

		int midel = sc.nextInt();
		try {
			int clist = mobileService.deleteMobile(midel);
			System.out.println("Mobile with mentioned ID is deleted. " + clist);
		} catch (MobileException e) {
			System.out.println(e.getMessage());
		}
		break;
		
		
	case 5 :
		System.out.println("Enter Customer Name:");

		String custName = sc.next();
		boolean validateCName = mobileService.validateCustName(custName);
		
		if (validateCName == true) {
			String custCase = custName.substring(0, 1).toUpperCase()
					+ custName.substring(1);
			
			purchase.setCustomerName(custCase);
		}
		
		System.out.println("Enter Mail Id :");
		String mailid = sc.next();

		boolean validateMailId = mobileService.validateEMailId(mailid);
		
		if (validateMailId == true) 
		{
			purchase.setEmailID(mailid);
		} else 
		{
			mobileAppLogger.error("Email ID validation failed");
			throw new MobileException("Please enter Valid Email ID");
		}
		
		System.out.println("Enter Phone Number :");
		String phone = sc.next();

		boolean validatePhone = mobileService.validateMobileNo(phone);
		
			if (validatePhone == true) 
			{
			purchase.setPhoneNo(phone);
			} else {
			mobileAppLogger.error("Mobile number validation failed.");
			throw new MobileException("Please enter valid(10 Digit) Mobile Number.");
			}
			
				
								
				try 
				{
				List<Mobile> clist = mobileService.getAllMobilesInfo();
					if (clist.size() != 0) 
					{
					System.out.print("Available Mobile ID's are");
						for (Mobile c : clist) 
						{
							System.out.print(" "+c.getMobileID());
						}
						System.out.println(" ");
					} else {
						System.out.println("No mobiles available currently");
					}
					
					System.out.println("Enter From Available Mobile ID list :");
					int mobileId = sc.nextInt();
					
					int mid=mobileService.getMobileId(mobileId);									
					

					if (mid!=0) 
					{
						
						purchase.setMobileID(mid);
					} else {
						mobileAppLogger.error("Mobile ID validation failed.");
						throw new MobileException("Please enter valid Mobile ID Number");
					}
					
					int purchaseid = mobileService.insertCustomerPurchaseDetails(purchase);
					
					if (true) 
						mobileService.updateMobileInfo(mobileId);
					System.out.println("Purchase Details inserted with mobile id : "+ purchaseid);
					} 
					catch (MobileException e) {
					System.out.println(e.getMessage());
					}
			
				break;
	case 6:
		do{
			System.exit(0);
		}while(true);
		
	case 7:
		break;
		default :System.out.println("Please enter correct option. ");
	}// end of switch 
	}while(true); // end of do while 
	}// end of main method
}
