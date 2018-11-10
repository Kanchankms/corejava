package com.capgemini.mobilepurchaseapp.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.mobilepurchaseapp.dao.MobileAppDaoImpl;
import com.capgemini.mobilepurchaseapp.exception.MobileException;
import com.capgemini.mobilepurchaseapp.util.DBConnection;



public class DBConnectionTest {
	static MobileAppDaoImpl daotest;
	static Connection dbCon;
	private static DBConnection instance = null;
	@BeforeClass
	public static void initialise() {
		daotest = new MobileAppDaoImpl();
		dbCon = null;
	}

	@Before
	public void beforeEachTest() {
		System.out.println("----Starting DBConnection Test Case----\n");
	}

	@Test
	public void test() throws MobileException, SQLException {
		Connection dbCon = DBConnection.getConnection();
		Assert.assertNotNull(dbCon);
	}

	@After
	public void afterEachTest() {
		System.out.println("----End of DBConnection Test Case----\n");
	}

	@AfterClass
	public static void destroy() {
		System.out.println("\t----End of Tests----");
		daotest = null;
		dbCon = null;
	}

}
