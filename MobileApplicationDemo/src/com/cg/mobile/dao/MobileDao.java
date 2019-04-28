package com.cg.mobile.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.mobile.dto.MobileDetails;
import com.cg.mobile.dto.PurchaseDetails;
import com.cg.mobile.exception.mobileException;
import com.cg.mobile.util.DatabaseConnectionObjectToUseasConnection;

public class MobileDao implements IMobileDao{
	Connection con;
	public MobileDao() {
		con=DatabaseConnectionObjectToUseasConnection.getConnection();
	}
	int generatePurchaseId(){
		int purchaseid=0;
		//String sql="select purchaseid_seq.nextval from dual";
		try{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(QueryMapper.PURCHASEID_SEQUENCE_QUERY);
			if(rs.next())
				purchaseid=rs.getInt(1);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return purchaseid;
	}
	@Override
	public int addPurchaseDetail(PurchaseDetails purchaseDetails) throws mobileException {
		//String sql="insert into purchasedetails values(?,?,?,?,?,?)";
		try{
			PreparedStatement ps=con.prepareStatement(QueryMapper.INSERT_PURCHASE_DETAILS);
			int purchaseid= generatePurchaseId();
			ps.setInt(1, purchaseid);
			ps.setString(2, purchaseDetails.getCname());
			ps.setString(3, purchaseDetails.getMailid());
			ps.setString(4, purchaseDetails.getPhoneno());
			ps.setDate(5, Date.valueOf(purchaseDetails.getPurchaseDate()));
			ps.setInt(6, purchaseDetails.getMobileid());
			int r=ps.executeUpdate();
			if(r==1)
				return purchaseid;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int updateMobileQty(int mobileid, int quantity) throws mobileException {
		//String sql="update mobiles set quantity=? where mobileid=?";
		Connection con=DatabaseConnectionObjectToUseasConnection.getConnection();
		try{
			PreparedStatement ps= con.prepareStatement(QueryMapper.UPDATE_MOBILE_QUANTITY);
			ps.setInt(1, mobileid);
			ps.setInt(2, quantity);
			int res=ps.executeUpdate();
			return res;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public ArrayList<MobileDetails> getMobileDetail() throws mobileException {
		ArrayList<MobileDetails> list=new ArrayList<MobileDetails>();
		try{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select mobileid,name from mobiles");
			while(rs.next()){
				MobileDetails mobDt=new MobileDetails();
				mobDt.setMobileid(rs.getInt(1));
				mobDt.setName(rs.getString(2));
				list.add(mobDt);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public ArrayList<MobileDetails> getAllMobileDetails() throws mobileException {
		ArrayList<MobileDetails> list=new ArrayList<MobileDetails>();
		try{
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(QueryMapper.SHOW_ALL_DETAILS);
			while(rs.next()){
				MobileDetails mobDetail=new MobileDetails();
				mobDetail.setMobileid(rs.getInt(1));
				mobDetail.setName(rs.getString(2));
				mobDetail.setPrice(rs.getInt(3));
				mobDetail.setQuantity(rs.getInt(4));
				list.add(mobDetail);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int deleteRow(int mobileid) throws mobileException {
		//String sql="delete from mobiles where mobileid=?";
		Connection con=DatabaseConnectionObjectToUseasConnection.getConnection();
		try{
			PreparedStatement ps= con.prepareStatement(QueryMapper.DELETE_MOBILE_QUERY);
			ps.setInt(1, mobileid);
			int res=ps.executeUpdate();
			return res ;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public ArrayList<MobileDetails> searchMobileOnPriceBased(int price)throws mobileException {
		ArrayList<MobileDetails> list=new ArrayList<>();
		try{
			//String sql="select * from mobiles where price<=?";
			PreparedStatement ps= con.prepareStatement(QueryMapper.SEARCH_MOBILE_QUERY);
			ps.setInt(1, price);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				MobileDetails mobDetail=new MobileDetails();
				mobDetail.setMobileid(rs.getInt(1));
				mobDetail.setName(rs.getString(2));
				mobDetail.setPrice(rs.getInt(3));
				mobDetail.setQuantity(rs.getInt(4));
				list.add(mobDetail);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
}
