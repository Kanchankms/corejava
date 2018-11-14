package com.cg.pwa.util;

import java.util.HashSet;


import com.cg.pwa.dto.Transaction;

public class CollectionUtilTransaction 
{

	private static HashSet<Transaction> transactionset = new HashSet<Transaction>();
	static
	{
		
	}
	
	public static void addTransaction(Transaction trans)
	{
		
		transactionset.add(trans);
	}
	public static HashSet<Transaction> getAllCustomerTransactions(){
		 
		 return transactionset;
	 }

}
