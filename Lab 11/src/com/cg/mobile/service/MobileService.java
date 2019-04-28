package com.cg.mobile.service;

import java.time.LocalDate;
import java.util.ArrayList;


import com.cg.mobile.dao.IMobileDao;
import com.cg.mobile.dao.MobileDao;
import com.cg.mobile.dto.MobileDetails;
import com.cg.mobile.dto.PurchaseDetails;
import com.cg.mobile.exception.mobileException;

public class MobileService implements IMobileService{
	IMobileDao dao;
	public MobileService() {
		dao=new MobileDao();
	}
	@Override
	public int addPurchaseDetail(PurchaseDetails purchaseDetails) throws mobileException {
		return dao.addPurchaseDetail(purchaseDetails);
	}
	
	@Override
	public int updateMobileQty(int mobileid, int quantity) throws mobileException {
		return dao.updateMobileQty(mobileid, quantity);
	}

	@Override
	public ArrayList<MobileDetails> getMobileDetail() throws mobileException {
		return dao.getMobileDetail();
	}

	@Override
	public ArrayList<MobileDetails> getAllMobileDetails() throws mobileException {
		return dao.getAllMobileDetails();
	}

	@Override
	public int deleteRow(int mobileid) throws mobileException {
		return dao.deleteRow(mobileid);
	}

	@Override
	public ArrayList<MobileDetails> searchMobileOnPriceBased(int price) throws mobileException {
		return dao.searchMobileOnPriceBased(price);
	}

	@Override
	public boolean validatePurchaseDetail(PurchaseDetails purchaseDetails)
			throws mobileException {
		if(!purchaseDetails.getCname().matches("[A-Z]{1}[a-z]{2,19}")){
			throw new mobileException("Customer name should start with capital letter");
		}
		if(!purchaseDetails.getMailid().matches("[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$")){  
			throw new mobileException("Enter valid Email Id ");
		}
		if(!purchaseDetails.getPhoneno().matches("[0-9]{10}")){
			throw new mobileException("Phone number should be of 10 digidts");
		}
		return true;  //".*@.*.com"
	}

	
}
