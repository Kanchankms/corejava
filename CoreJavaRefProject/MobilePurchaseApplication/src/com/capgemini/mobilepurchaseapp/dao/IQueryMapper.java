package com.capgemini.mobilepurchaseapp.dao;

public interface IQueryMapper {

	
	public static final String INSERT_MOBILEINFO_QUERY="INSERT INTO mobiles VALUES(mobileid_seq.NEXTVAL,?,?,?)";
	public static final String INSERT_CUSTPURCHASEINFO_QUERY="INSERT INTO purchasedetails VALUES(custpurchaseid_seq.NEXTVAL,?,?,SYSDATE,?,?)";
	public static final String MOBILEID_QUERY_SEQUENCE="SELECT mobileid_seq.CURRVAL FROM DUAL";
	public static final String PURCHASEID_QUERY_SEQUENCE="SELECT custpurchaseid_seq.CURRVAL FROM DUAL";
	public static final String RETRIVE_ALL_MOBILES_QUERY="SELECT mobileid, name, quantity, price FROM mobiles order by mobileid";
	public static final String SEARCH_MOBILES_QUERY="SELECT mobileid, name, price,quantity FROM mobiles WHERE price BETWEEN ? and ?";
	public static final String DELETE_MOBILE_QUERY="DELETE FROM mobiles WHERE mobileid=?";
	public static final String UPDATE_MOBILE_QUERY="UPDATE MOBILES SET QUANTITY=QUANTITY-1 WHERE MOBILEID=?";
	public static final String SEARCH_MOBILEID_QUERY= "SELECT mobileid from mobiles WHERE MOBILEID=?";
	//public static final String CHECK_MOBILEID_QUERY= "SELECT 1 into count from mobiles WHERE m.MOBILEID=p.MobileID"; 
	//public static final String VALID_MOBILEID_QUERY= "select p.purchaseid,p.cname from purchasedetails p where p.mobileid in (select mobileid from mobiles);";


}


