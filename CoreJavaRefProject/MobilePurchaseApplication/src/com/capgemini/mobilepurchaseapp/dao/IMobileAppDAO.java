package com.capgemini.mobilepurchaseapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.mobilepurchaseapp.bean.Mobile;
import com.capgemini.mobilepurchaseapp.bean.PurchaseDetails;
import com.capgemini.mobilepurchaseapp.exception.MobileException;

public interface IMobileAppDAO {

	int insertMobileInfo(Mobile mob) throws MobileException, SQLException;
	List<Mobile> searchMobile(int startval,int highval) throws MobileException, SQLException;
	List<Mobile> getAllMobilesInfo() throws MobileException, SQLException;
	int deleteMobile(int mobid) throws MobileException, SQLException;
	int insertCustomerPurchaseDetails(PurchaseDetails purchasedet) throws MobileException, SQLException;
	int updateMobileInfo(int mobileid) throws MobileException, SQLException;
	int getMobileId(int mobileId) throws MobileException, SQLException;
//	public boolean validateMobileID(int mobileId) throws MobileException, SQLException;
	
}
