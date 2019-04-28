package com.cg.mobile.dto;

public class MobileDetails {
	private int mobileid;
	private String name;
	private int price;
	private int quantity;
	/*public MobileDetails() {
		
	}*/
	public int getMobileid() {
		return mobileid;
	}
	public void setMobileid(int mobileid) {
		this.mobileid = mobileid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "MobileDetails [mobileid=" + mobileid + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}
	
	
}
