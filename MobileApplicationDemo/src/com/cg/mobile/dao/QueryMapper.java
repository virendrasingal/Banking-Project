package com.cg.mobile.dao;

public interface QueryMapper {
	public static final String PURCHASEID_SEQUENCE_QUERY="SELECT purchaseid_seq.NEXTVAL FROM DUAL";
	public static final String INSERT_PURCHASE_DETAILS="INSERT into purchasedetails values(?,?,?,?,?,?)";
	public static final String UPDATE_MOBILE_QUANTITY="UPDATE mobiles set quantity=? WHERE mobileid=?";
	public static final String SEARCH_MOBILE_QUERY="select * from mobiles where price<=?";
	public static final String DELETE_MOBILE_QUERY="delete from mobiles where mobileid=?";
	public static final String SHOW_ALL_DETAILS="select * from mobiles";
	

}
