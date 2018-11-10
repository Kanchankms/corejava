package com.capgemini.mobilepurchaseapp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.mobilepurchaseapp.bean.Mobile;
import com.capgemini.mobilepurchaseapp.bean.PurchaseDetails;
import com.capgemini.mobilepurchaseapp.dao.MobileAppDaoImpl;
import com.capgemini.mobilepurchaseapp.exception.MobileException;


public class MobileServiceImpl implements IMobileService{

	MobileAppDaoImpl dao;
	
	public MobileServiceImpl() {
		dao=  new MobileAppDaoImpl();
	}
		
	
	@Override
	public int insertMobileInfo(Mobile mob) throws MobileException,
			SQLException {
		return dao.insertMobileInfo(mob);
	}

	
	@Override
	public int insertCustomerPurchaseDetails(PurchaseDetails purchasedet)
			throws MobileException, SQLException {
		return dao.insertCustomerPurchaseDetails(purchasedet);
	}
	
	
	@Override
	public List<Mobile> searchMobile(int startval, int highval) throws MobileException,
			SQLException {
		return dao.searchMobile(startval, highval);
	}

	@Override
	public List<Mobile> getAllMobilesInfo() throws MobileException,
			SQLException {
		return dao.getAllMobilesInfo();
	}

	@Override
	public int deleteMobile(int mobid) throws MobileException, SQLException {
		return dao.deleteMobile(mobid);
	}



	@Override
	public int updateMobileInfo(int mobileid) throws MobileException,
			SQLException {
		return dao.updateMobileInfo(mobileid);
	}
	
	
	

	public boolean validateCustName(String name) {
		
		Pattern pattern= Pattern.compile("[A-Z][a-z]{2,19}");
		Matcher matcher= pattern.matcher(name);
		return matcher.matches();
	}

	
	public boolean validateEMailId(String mailid) {
		Pattern pattern= Pattern.compile("[A-Za-z0-9]*@capgemini.com");
		Matcher matcher= pattern.matcher(mailid);
		return matcher.matches();
	}
      
	public boolean validateMobileNo(String mobno) {
		Pattern pattern= Pattern.compile("[0-9]{10}");
		Matcher matcher= pattern.matcher(mobno);
		return matcher.matches();
	}


/*	@Override
public boolean validateMobileID(int mobileId) throws MobileException,
			SQLException {
		return dao.validateMobileID(mobileId);
	}*/


	@Override
	public int getMobileId(int mobileId) throws MobileException, SQLException {
		return dao.getMobileId(mobileId);
	}


	

	
	


	
	
}
