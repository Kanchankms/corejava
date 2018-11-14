package com.cg.pwa.dto;

import java.time.LocalDate;

public class Transaction
{
	private Long phoneNum;
	private Long transId;
	private String transType;
	private LocalDate transDate;
	private double transAmount;
	
	
	public Long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Long getTransId() {
		return transId;
	}
	public void setTransId(Long transId) {
		this.transId = transId;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public LocalDate getTransDate() {
		return transDate;
	}
	public void setTransDate(LocalDate transDate) {
		this.transDate = transDate;
	}
	public double getTransAmount() {
		return transAmount;
	}
	public void setTransAmount(double transAmount) {
		this.transAmount = transAmount;
	}
	public Transaction(Long phoneNum, Long transId, String transType,
			LocalDate transDate, double transAmount) {
		super();
		this.phoneNum = phoneNum;
		this.transId = transId;
		this.transType = transType;
		this.transDate = transDate;
		this.transAmount = transAmount;
	}
	@Override
	public String toString() {
		return "Transaction [phoneNum=" + phoneNum + ", transId=" + transId
				+ ", transType=" + transType + ", transDate=" + transDate
				+ ", transAmount=" + transAmount + "]";
	}
	
	
	
	
	
}
