package com.capgemini.mobilepurchaseapp.bean;

public class Mobile {
	private int mobileID;
	private String mobileName;
	private float mobilePrice;
	private int mobileQty;
	
	public Mobile() {
		super();
	}
	

	public Mobile(int mobileID, String mobileName, float mobilePrice,
			int mobileQty) {
		super();
		this.mobileID = mobileID;
		this.mobileName = mobileName;
		this.mobilePrice = mobilePrice;
		this.mobileQty = mobileQty;
	}
	public int getMobileID() {
		return mobileID;
	}
	public void setMobileID(int mobileID) {
		this.mobileID = mobileID;
	}
	public String getMobileName() {
		return mobileName;
	}
	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}
	public float getMobilePrice() {
		return mobilePrice;
	}
	public void setMobilePrice(float mobilePrice) {
		this.mobilePrice = mobilePrice;
	}
	public int getMobileQty() {
		return mobileQty;
	}
	public void setMobileQty(int mobileQty) {
		this.mobileQty = mobileQty;
	}
	
	
	@Override
	public String toString() {
		return "MobileDetails [MobileID=" + mobileID + ", MobileName=" + mobileName
				+ ", MobilePrice=" + mobilePrice + ", MobileQuantity=" + mobileQty
				+ "]";
	}


	
}
