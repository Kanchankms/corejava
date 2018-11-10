package com.capgemini.mobilepurchaseapp.service;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.mobilepurchaseapp.bean.Mobile;
import com.capgemini.mobilepurchaseapp.bean.PurchaseDetails;
import com.capgemini.mobilepurchaseapp.exception.MobileException;

public interface IMobileService {
	
	int insertMobileInfo(Mobile mob) throws MobileException, SQLException;
	List<Mobile> searchMobile(int startval,int highval) throws MobileException, SQLException;
	List<Mobile> getAllMobilesInfo() throws MobileException, SQLException;
	int deleteMobile(int mobid) throws MobileException, SQLException;
	int insertCustomerPurchaseDetails(PurchaseDetails purchasedet) throws MobileException, SQLException;
	int updateMobileInfo(int mobileid) throws MobileException, SQLException;
	public boolean validateCustName(String name) ;
	public boolean validateEMailId(String mailid);
	public boolean validateMobileNo(String mobno);
	//public boolean validateMobileID(int mobileId)throws MobileException, SQLException ;
	public int getMobileId(int mobileId) throws MobileException, SQLException;
}
