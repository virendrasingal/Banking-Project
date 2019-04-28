package com.cg.mobile.dto;

import java.time.LocalDate;

public class PurchaseDetails {
	private int purchaseid;
	private String cname;
	private String mailid;
	private String phoneno;
	private LocalDate purchaseDate;
	private int mobileid;
	
	

	
	
	public PurchaseDetails() {
		
	}
	public PurchaseDetails(String cname, String mailid, String phoneno,
			LocalDate purchaseDate, int mobileid) {
		
		this.cname = cname;
		this.mailid = mailid;
		this.phoneno = phoneno;
		this.purchaseDate = purchaseDate;
		this.mobileid = mobileid;
	}
	public int getMobileid() {
		return mobileid;
	}
	public void setMobileid(int mobileid) {
		this.mobileid = mobileid;
	}
	public int getPurchaseid() {
		return purchaseid;
	}
	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	@Override
	public String toString() {
		return "PurchaseDetails [purchaseid=" + purchaseid + ", cname=" + cname
				+ ", mailid=" + mailid + ", phoneno=" + phoneno
				+ ", purchaseDate=" + purchaseDate + ", mobileid=" + mobileid
				+ "]";
	}
	
	
}
