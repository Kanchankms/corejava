package com.cg.pwa.dao;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import com.cg.pwa.util.CollectionUtilAccount;
import com.cg.pwa.util.CollectionUtilCustomer;
import com.cg.pwa.util.CollectionUtilTransaction;
import com.cg.pwa.dto.Account;
import com.cg.pwa.dto.Customer;
import com.cg.pwa.dto.Transaction;
import com.cg.pwa.exception.PaymentAppException;

public class PaymentAppDaoImpl  implements IPaymentAppDao{

	@Override
	public void createAccount(Customer cust) 
	{
		Account obj;
		obj=getAccountByMobile(cust.getMobileNum());
		cust.setAccount(obj);
		CollectionUtilCustomer.addCustomer(cust);
	}

	@Override
	public double showBalance(Long mobile) 
	{
		HashSet<Customer> tempset = CollectionUtilCustomer.getAllCustomers();
		double currbalnc=0;
		Iterator<Customer> it = tempset.iterator();
		boolean flag=false;
		while(it.hasNext())
		{
			Customer custobj =it.next();
			if((custobj.getMobileNum().equals(mobile)))
			{
				currbalnc=custobj.getAccBalance();
			}

		}
		return currbalnc;


	}

	@Override
	public double deposit(Long mobile, double depamnt) 
	{
		double updatedAccB=0, updatedCusB=0;
		HashSet<Account> accSet= CollectionUtilAccount.getAccount();
		HashSet<Customer> cusSet = CollectionUtilCustomer.getAllCustomers();
		Iterator<Account> accit = accSet.iterator();
		Iterator<Customer> cusit = cusSet.iterator();
		while(cusit.hasNext())
		{
			
			Customer cusObj = cusit.next();
			while(accit.hasNext())
			{
				Account accObj=accit.next();

				if(accObj.getMobileNumber().equals(cusObj.getMobileNum()))
				{
					
					updatedAccB=accObj.getBalance()-depamnt;
					accObj.setBalance(updatedAccB);
					updatedCusB=cusObj.getAccBalance()+depamnt;
					cusObj.setAccBalance(updatedCusB);
					addTransactions(mobile, "Deposited", depamnt);
					break;
				}
			}
		}
		return updatedCusB;
	}

	@Override
	public double withdraw(Long mobile, double wdamnt)
	{
		double updatedBal=0;
		HashSet<Customer> custSet= CollectionUtilCustomer.getAllCustomers();
		Iterator<Customer> cusit = custSet.iterator();
		while(cusit.hasNext())
		{
			Customer cusObj = cusit.next();
			if(cusObj.getMobileNum().equals(mobile) )
			{
				updatedBal=cusObj.getAccBalance()-wdamnt;
				cusObj.setAccBalance(updatedBal);
				addTransactions(mobile, "Withdrawl", wdamnt);
			}
		}
	return updatedBal;

	}

	@Override
	public double fundsTranfer(Long mobile,Long mobileReceiver, double transferAmnt) 
	{
		double updatedBal;
		HashSet<Customer> custSet= CollectionUtilCustomer.getAllCustomers();
		Iterator<Customer> cusit = custSet.iterator();
		while(cusit.hasNext())
		{
			Customer cusObj = cusit.next();
			if(cusObj.getMobileNum().equals(mobileReceiver) )
			{
				updatedBal=cusObj.getAccBalance()+transferAmnt;
				cusObj.setAccBalance(updatedBal);
				addTransactions(mobile, "Transferred", transferAmnt);
			}
		}
		return withdraw(mobile,transferAmnt); 
	}

	@Override
	public HashSet<Customer> getAll() 
	{
		HashSet<Customer> tempset=CollectionUtilCustomer.getAllCustomers();
		return tempset;

	}

	@Override
	public HashSet<Account> getAccount(Long mobile) 
	{
		return CollectionUtilAccount.getAccount();
	}

	@Override
	public Account getAccountByMobile(Long mobile)
	{
		Account obj=null;
		HashSet<Account> accSet= CollectionUtilAccount.getAccount();
		Iterator<Account> accit = accSet.iterator();
		while(accit.hasNext())
		{
			Account acc = accit.next();
			if(mobile.equals(acc.getMobileNumber()) )
			{
				return acc;
			}		
		}
		return null;
	}

	@Override
	public void addTransactions(Long mobile,String type, double amount) {
		
		LocalDate transDate = LocalDate.now();
		Customer cusObj = new Customer();
		Long transId=(long) (Math.random()*100000000);
		
		cusObj.setTransaction(new Transaction(mobile,transId,type,transDate,amount));
		CollectionUtilTransaction.addTransaction(new Transaction(mobile,transId,type,transDate,amount));
		
		
	}

	public HashSet<Transaction> fetchAllTransactions(Long mobile) {
		
		HashSet<Transaction> allTSet= new HashSet<Transaction>();
		HashSet<Transaction> transet = CollectionUtilTransaction.getAllCustomerTransactions();
		Iterator<Transaction> tset = transet.iterator();
		while(tset.hasNext())
		{
			Transaction tobj= tset.next();
			if(tobj.getPhoneNum().equals(mobile))
			{
				allTSet.add(tobj);
			}
		}
		return allTSet;
	}

	@Override
	public double getBankBalance(Long uname) {
		
		HashSet<Account> aset = CollectionUtilAccount.getAccount();
		Iterator<Account> accit = aset.iterator();
		double bal=0;
		while(accit.hasNext())
		{
			Account acc = accit.next();
			if(uname.equals(acc.getMobileNumber()) )
			{
				bal= acc.getBalance();
			}		
		}
		
		return bal;
	}

}
