package com.cg.mobile.service;

import java.util.ArrayList;
import com.cg.mobile.dto.MobileDetails;
import com.cg.mobile.dto.PurchaseDetails;
import com.cg.mobile.exception.mobileException;


public interface IMobileService {
	public int addPurchaseDetail(PurchaseDetails purchaseDetails)throws mobileException;
	public ArrayList<MobileDetails> getMobileDetail()throws mobileException;
	public int updateMobileQty(int mobileid,int quantity)throws mobileException;
	public ArrayList<MobileDetails> getAllMobileDetails()throws mobileException;
	public ArrayList<MobileDetails> searchMobileOnPriceBased(int price)throws mobileException;
	public int deleteRow(int mobileid)throws mobileException;
	boolean validatePurchaseDetail(PurchaseDetails purchaseDetails)throws mobileException;
}
