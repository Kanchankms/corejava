package com.cg.pwa.util;
import java.util.HashSet;

import com.cg.pwa.dto.*;

public class CollectionUtilAccount {

	
		private static HashSet<Account> accountset = new HashSet<Account>();
		static
		{
			accountset.add(new Account(7059786176L,"HDFC123",3000.0));
			accountset.add(new Account(8981200375L,"HDFC456",2000.0));
		}
		
		
		public static HashSet<Account> getAccount(){
			 
			 return accountset;
		 }
		
		
		
		
	}


