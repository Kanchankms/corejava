package com.cg.pwa.util;

import java.util.HashSet;


import com.cg.pwa.dto.Customer;

public class CollectionUtilCustomer 
{
	private static HashSet<Customer> customerset = new HashSet<Customer>();
	static
	{
		
	}
	
	public static void addCustomer(Customer customer){
		
		customerset.add(customer);
	}
	public static HashSet<Customer> getAllCustomers(){
		 
		 return customerset;
	 }
	
	
	
	
}
