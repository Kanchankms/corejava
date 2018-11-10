package com.capgemini.mobilepurchaseapp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.mobilepurchaseapp.bean.Mobile;
import com.capgemini.mobilepurchaseapp.bean.PurchaseDetails;
import com.capgemini.mobilepurchaseapp.dao.MobileAppDaoImpl;
import com.capgemini.mobilepurchaseapp.exception.MobileException;
import com.capgemini.mobilepurchaseapp.service.IMobileService;
import com.capgemini.mobilepurchaseapp.service.MobileServiceImpl;


public class MobilePurchaseAppDAOTest {
IMobileService iMobileService;
	
	@Before
	public void setup(){
		iMobileService = new MobileServiceImpl();
	} 

	@Test
	public void testAddMobileDetails() throws MobileException, SQLException{
		Mobile bean = new Mobile();
		bean.setMobileName("HonorPro");
		bean.setMobilePrice(20000.30f);
		bean.setMobileQty(5);
		try {
			int reqId = iMobileService.insertMobileInfo(bean);
			assertEquals("Test case passed successfully", 1, reqId);
		} catch (MobileException e) {
			// TODO Auto-generated catch block
			throw new MobileException(e.getMessage());
		}
	}
	
	@Test
	public void testSearchMobileDetails() throws MobileException, SQLException{
		int bean = 0;
		int reqId = 1006;
		try {
			bean = iMobileService.getMobileId(reqId);
		} catch (MobileException e) {
			// TODO Auto-generated catch block
			throw new MobileException(e.getMessage());
		}
		assertNotNull(bean);
	}
	@Test
	public void testAddPurchaseDetails() throws MobileException, SQLException{
		PurchaseDetails bean = new PurchaseDetails();
		bean.setCustomerName("Ovi");
		bean.setEmailID("ovi@capgemini.com");
		bean.setPhoneNo("9876679876");
		bean.setMobileID(1003);
		
		try {
			int reqId = iMobileService.insertCustomerPurchaseDetails(bean);
			assertEquals("Test case passed successfully", 13, reqId);
		} catch (MobileException e) {
			// TODO Auto-generated catch block
			throw new MobileException(e.getMessage());
		}
	}
	
	@Test
	public void testSearchMobilesInRange() throws MobileException, SQLException{
		int minval=2000;
		int maxval=10000;
		
		MobileAppDaoImpl dao = new MobileAppDaoImpl();
		try {
			List<Mobile> moblist = dao.searchMobile(minval, maxval);
			Assert.assertTrue(moblist.size() > 0);
		} catch (MobileException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testGetAllMobilesInfo() throws SQLException {

		MobileAppDaoImpl dao = new MobileAppDaoImpl();
		try {
			List<Mobile> moblist = dao.getAllMobilesInfo();
			Assert.assertTrue(moblist.size() > 0);
		} catch (MobileException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateMobileInfo() throws SQLException {
		MobileAppDaoImpl dao = new MobileAppDaoImpl();
		try {
			int count = dao.updateMobileInfo(1012);
			System.out.println(count);
			Assert.assertTrue(count != 0);
		} catch (MobileException e) {
			e.printStackTrace();
		}

	}

	
}
