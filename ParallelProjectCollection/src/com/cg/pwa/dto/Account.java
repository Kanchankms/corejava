package com.cg.pwa.dto;

public class Account 
{
	private Long mobileNumber;
	private String AccountNumber;
	private double balance;
	
	@Override
	public String toString() {
		return "Account [mobileNumber=" + mobileNumber + ", AccountNumber=" + AccountNumber + ", balance=" + balance
				+ "]";
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(Long i, String accountNumber, double balance) {
		super();
		this.mobileNumber = i;
		AccountNumber = accountNumber;
		this.balance = balance;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
