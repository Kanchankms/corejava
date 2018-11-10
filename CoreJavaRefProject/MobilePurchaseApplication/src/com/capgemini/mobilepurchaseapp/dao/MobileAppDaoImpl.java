package com.capgemini.mobilepurchaseapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import com.capgemini.mobilepurchaseapp.bean.Mobile;
import com.capgemini.mobilepurchaseapp.bean.PurchaseDetails;
import com.capgemini.mobilepurchaseapp.exception.MobileException;
import com.capgemini.mobilepurchaseapp.util.DBConnection;
import com.capgemini.mobilepurchaseapp.dao.MobileAppDaoImpl;



public class MobileAppDaoImpl implements IMobileAppDAO  {
	
	Connection conn;
	static Logger mobileAppLogger;
	Mobile mobile= new Mobile();
	
	public static void logger()
	{
	PropertyConfigurator.configure("resources/log4j.properties");
	mobileAppLogger = Logger.getLogger(MobileAppDaoImpl.class.getName());
	}
	

	private int generateNewMobileID() throws MobileException, SQLException {
		int mobileID = 0;
		String sql = IQueryMapper.MOBILEID_QUERY_SEQUENCE;
		Statement stmt = null;
		ResultSet result = null;
		conn = DBConnection.getConnection();

		try {
			stmt = conn.createStatement();
			result = stmt.executeQuery(sql);
			result.next();
			mobileID = result.getInt(1);
		
		} catch (SQLException se) {
			se.printStackTrace();
			se.getMessage();
			throw new MobileException("Mobile ID generation error. "+ se.getMessage());
		} 
		return mobileID;
	}
	
	
	private int generateCustomerPurchaseID() throws MobileException,
	SQLException {
		int custPurchaseID = 0;
		String sql = IQueryMapper.PURCHASEID_QUERY_SEQUENCE;

		conn = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet result = null;

		try {
			
			stmt = conn.createStatement();
			result = stmt.executeQuery(sql);
			result.next();
			custPurchaseID = result.getInt(1);
			
		} catch (SQLException se) {		
			throw new MobileException("Purchase ID for Customer generation error. "+ se.getMessage());
		}
		return custPurchaseID;
	}


	@Override
	public int insertMobileInfo(Mobile newMob) throws MobileException,SQLException {
		
		
		
		String sql = IQueryMapper.INSERT_MOBILEINFO_QUERY;

		conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		
		int result=0;
		try {
			
			pstmt = conn.prepareStatement(sql);
			
						
			//pstmt.setInt(1, newMob.getMobileID());
			pstmt.setString(1, newMob.getMobileName());
			pstmt.setFloat(2, newMob.getMobilePrice());
			pstmt.setInt(3, newMob.getMobileQty());
			
			result=pstmt.executeUpdate();
			newMob.setMobileID(generateNewMobileID());
			
			logger();
			mobileAppLogger.info("Mobile info inserting into database. "); 
			mobileAppLogger.debug("Mobile info insertion operation performed successfully");
			
		} catch (SQLException se) {
			mobileAppLogger.error("Validation failed while insering mobile details");
			throw new MobileException("Problem in inserting mobile details..."	+ se.getMessage());
		} finally {
			conn.commit();
		}
		return result;
	}
	
	@Override
	public int getMobileId(int mobid) throws MobileException, SQLException {
		String sql = IQueryMapper.SEARCH_MOBILEID_QUERY;
		conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		
		int result;
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mobid);
			result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("Mobile with ID" + mobid+ " is available in Database");
			} 
			else 
			{
				System.out.println("Mobile with mentioned ID does not exists.");
				throw new MobileException("Unable to fetch mentioned MobileID");
			}
			logger();
			mobileAppLogger.info("MobileID fetched from database.");
			mobileAppLogger.debug("Mobile with mentioned ID retrived successfully.");
		} catch (SQLException se) {
			mobileAppLogger.error("Mobile ID validation failed.");
			throw new MobileException("Unable to fetch Mobile with mentioned ID" + se.getMessage());
		} finally {
			conn.commit();
			
		}
		
		return result;
	}
	
	
	
	
	
	@Override
	public int insertCustomerPurchaseDetails(PurchaseDetails purchasedet)
			throws MobileException, SQLException {
		
		
		
		String sql = IQueryMapper.INSERT_CUSTPURCHASEINFO_QUERY;
		int purchaseID = 0;
		conn = DBConnection.getConnection();
		

		try {
			logger();
			mobileAppLogger.info("Inserting Customer Purchase Details into Database.");
			PreparedStatement pst = conn.prepareStatement(sql);
			//pst.setInt(1, purchasedet.getPurchaseID());
			pst.setString(1, purchasedet.getCustomerName());
			pst.setString(2, purchasedet.getEmailID());
			pst.setString(3, purchasedet.getPhoneNo());
			pst.setInt(4, purchasedet.getMobileID());
			
			purchaseID = pst.executeUpdate();
			purchasedet.setPurchaseID(generateCustomerPurchaseID());
			int result=0;
			if (result == 1)
			 {
				 Statement st= conn.createStatement(); 
				 ResultSet rset=st.executeQuery(IQueryMapper.PURCHASEID_QUERY_SEQUENCE);
				 if(rset.next())
				 {
					 purchaseID= rset.getInt(1); 
					 Mobile mob= new Mobile(); 
					 //mob.setMobileID(purchasedet.getMobileID());
					 updateMobileInfo(mob.getMobileID()); 
				 } 
			 }
			 
			 mobileAppLogger.debug("Customer Purchase Details updated successfully");
		} catch (SQLException se) {
			mobileAppLogger.error("CustomerPurchaseDetails updation failed.");
			if (se.getErrorCode() == 2291)
				throw new MobileException("Mobile ID is invalid ");
			else
				throw new MobileException(se.getMessage());
		} finally {
			conn.commit();
			
		}
		
		return purchaseID;
	}
	
	

	@Override
	public List<Mobile> searchMobile(int startval, int highval) throws MobileException,SQLException {
		String sql = IQueryMapper.SEARCH_MOBILES_QUERY;
		Mobile mobile = null;
		List<Mobile> moblist = new ArrayList<Mobile>();
		conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		try {
			logger();
			mobileAppLogger.info("Searching mobiles in mentioned range.");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startval);
			pstmt.setInt(2, highval);
			result = pstmt.executeQuery();
			while (result.next()) {
				mobile = new Mobile();
				mobile.setMobileID(result.getInt("mobileid"));
				mobile.setMobileName(result.getString("name"));
				mobile.setMobileQty(result.getInt("quantity"));
				mobile.setMobilePrice(result.getInt("price"));
				moblist.add(mobile);
			}
			
			mobileAppLogger.debug("Search Operation performed successfully");
		} catch (SQLException e) {
			mobileAppLogger.error("Search operation for mobiles in mentioned range failed.");
			throw new MobileException("Unable to fetch mobiles in mentioned range"+ e.getMessage());
		} finally {
			conn.commit();
		}
		return moblist;
	}

	@Override
	public List<Mobile> getAllMobilesInfo() throws MobileException,
			SQLException {
		String sql =IQueryMapper.RETRIVE_ALL_MOBILES_QUERY;
		List<Mobile> moblist = new ArrayList<Mobile>();

		conn = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet result = null;
		
		try {
			
			stmt = conn.createStatement();
			result = stmt.executeQuery(sql);
			while (result.next()) {
				Mobile mobile = new Mobile();
				mobile.setMobileID(result.getInt("mobileid"));
				mobile.setMobileName(result.getString("name"));
				mobile.setMobilePrice(result.getFloat("price"));
				mobile.setMobileQty(result.getInt("quantity"));
				
				moblist.add(mobile);
			}
			logger();
			mobileAppLogger.info("Retrived all mobiles info.");
			mobileAppLogger.debug("All mobiles info retrived successfully.");
		} catch (SQLException se) {
			mobileAppLogger.error("Unable to fetch mobiles info.");
			throw new MobileException("Problem occured while fetching information of all mobiles."+ se.getMessage());
		} finally {
			conn.commit();
		}
		return moblist;
	}

	@Override
	public int deleteMobile(int mobid) throws MobileException, SQLException {
		String sql = IQueryMapper.DELETE_MOBILE_QUERY;
		conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		
		int res;
		try {
			logger();
			mobileAppLogger.info("Deleting mobile with mentioned ID.");
			//System.out.println("Delete Mobile Method Entering");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mobid);
			res = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Mobile with" + mobid + " got deleted from database");
			mobileAppLogger.debug("Mobile info for mentioned ID deleted successfully.");
		} catch (SQLException se) {
			se.printStackTrace();se.getMessage();
			mobileAppLogger.error("Mobile deletion failed.");
			throw new MobileException("Problem occured while deleting mobile with mentioned ID."+ se.getMessage());		
			} 
		finally {
			conn.commit();
		}
		return res;
	}



	@Override
	public int updateMobileInfo(int mobileid) throws MobileException,
			SQLException {
		String sql = IQueryMapper.UPDATE_MOBILE_QUERY;
		conn = DBConnection.getConnection();
		PreparedStatement pst = null;
		
		int result;
		try {
			logger();
			mobileAppLogger.info("Mobile quantity getting updated in database. ");
			pst = conn.prepareStatement(sql);
			pst.setInt(1,mobileid);
			result = pst.executeUpdate();
			System.out.println("Quantity of mobile with " + mobileid+ " updated in database. ");
			mobileAppLogger.debug("Updation of mobile quantity done successfully.");
		} catch (SQLException se) {
			mobileAppLogger.error("Updation of mobile quantity failed.");
			throw new MobileException("Mobile quantity updation failed."+ se.getMessage());
		} finally {
			conn.commit();
		
			
		}
		
		return result;
	}




	
		
		
		
	}


