package com.cg.pwa.dao;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;

import com.cg.pwa.dto.Account;
import com.cg.pwa.dto.Customer;
import com.cg.pwa.dto.Transaction;
import com.cg.pwa.exception.PaymentAppException;

public interface IPaymentAppDao {
	
	public void createAccount(Customer cust);
	public double showBalance(Long mobile);
	public double deposit(Long mobile,double depamnt);
	public double withdraw(Long mobile,double wdamnt);
	public double fundsTranfer(Long mobile,Long mobileReceiver,double transferAmnt);
	public void addTransactions(Long mobile,String type,double amount);
	public HashSet<Customer> getAll();
	public HashSet<Account> getAccount(Long mobile);
	public Account getAccountByMobile(Long mobile);
	public HashSet<Transaction> fetchAllTransactions(Long mobile);
	public double getBankBalance(Long uname);
	

}
