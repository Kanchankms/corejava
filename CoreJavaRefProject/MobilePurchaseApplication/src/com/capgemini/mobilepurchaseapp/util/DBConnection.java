package com.capgemini.mobilepurchaseapp.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.capgemini.mobilepurchaseapp.exception.MobileException;

public class DBConnection {
	private static Connection conn=null;
	
	/*****************************************************************
	 *  - Method Name:getConnection() 
	 *  - Input Parameters : 
	 *  - Return Type :DBConnection instance
	 *  - Throws : MobileException 
	 *  - Author : VarshaL
	 *  - Creation Date : 23/02/1018
	 *  - Description :  Returns connection object
	 *******************************************************************/
	
	public static Connection getConnection() throws MobileException, SQLException{
		if(conn==null){
			try {
				FileInputStream myFile = new FileInputStream("resources/JDBCProp.properties");
				Properties props = new Properties();
				props.load(myFile);
				
				String driver = props.getProperty("driver");
				String dburl = props.getProperty("dburl");
				String user = props.getProperty("username");
				String pass = props.getProperty("password");
				Class.forName(driver);
				conn = DriverManager.getConnection(dburl, user, pass);
				conn.commit();
				
			} catch (FileNotFoundException fe) {
				throw new MobileException("Unable to find Properties file."+fe.getMessage());
			} catch (ClassNotFoundException ce) {
				throw new MobileException("Driver class not found."+ce.getMessage());
			} catch (IOException ie) {
				throw new MobileException("Problem occured while reading property."+ie.getMessage());
			} catch (SQLException se) {
				se.printStackTrace();
				throw new MobileException("Problem occured while obtaining connection."+se.getMessage());
			}
			
		}
		
		return conn;
	}
}
