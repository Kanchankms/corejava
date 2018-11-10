package com.capgemini.mobilepurchaseapp.bean;

import java.util.Date;


public class PurchaseDetails {
	private int purchaseID;
	private String customerName;
	private String emailID;
	private Date purchaseDate;
	private String phoneNo;
	private int mobileID;
	
	public PurchaseDetails() {
		super();
	}

	public PurchaseDetails(int purchaseID, String customerName, String emailID,
			Date purchaseDate, String phoneNo, int mobileID) {
		super();
		this.purchaseID = purchaseID;
		this.customerName = customerName;
		this.emailID = emailID;
		this.purchaseDate = purchaseDate;
		this.phoneNo = phoneNo;
		this.mobileID = mobileID;
	}

	public int getPurchaseID() {
		return purchaseID;
	}

	public void setPurchaseID(int purchaseID) {
		this.purchaseID = purchaseID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getMobileID() {
		return mobileID;
	}

	public void setMobileID(int mobileID) {
		this.mobileID = mobileID;
	}

	@Override
	public String toString() {
		return "PurchaseDetails [PurchaseID=" + purchaseID + ", CustomerName="
				+ customerName + ", emailID=" + emailID + ", PurchaseDate="
				+ purchaseDate + ", PhoneNo=" + phoneNo + ", MobileID="
				+ mobileID + "]";
	}
	
	
}
