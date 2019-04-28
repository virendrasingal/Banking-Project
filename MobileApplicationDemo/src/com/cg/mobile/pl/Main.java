package com.cg.mobile.pl;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.mobile.dto.MobileDetails;
import com.cg.mobile.dto.PurchaseDetails;
import com.cg.mobile.exception.mobileException;
import com.cg.mobile.service.IMobileService;
import com.cg.mobile.service.MobileService;
public class Main {
	public void acceptPuchaseDetails(PurchaseDetails purchaseDetails)throws mobileException{
		IMobileService service=new MobileService();
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Customer Name : ");
		String cname=sc.next();
		System.out.println("Enter mail Id : ");
		String mailid=sc.next();
		System.out.println("Enter phone number : ");
		String phoneno=sc.next();
		System.out.println("Enter Purchase Date :(dd-MM-yyyy) ");
		String str=sc.next();
		DateTimeFormatter fmt= DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date=LocalDate.parse(str, fmt);
		System.out.println("Select Mobile id.....");
		ArrayList<MobileDetails> list=service.getMobileDetail();
		for(MobileDetails mobDt:list) {
			System.out.println(mobDt.getMobileid()+" "+mobDt.getName());
		}
		int no=sc.nextInt();
		purchaseDetails.setCname(cname);
		purchaseDetails.setMailid(mailid);
		purchaseDetails.setPhoneno(phoneno);
		purchaseDetails.setPurchaseDate(date);
		purchaseDetails.setMobileid(no);
}
	public static void main(String[] args) {
		Main obj=new Main();
		IMobileService service=new MobileService();
		PurchaseDetails purchaseDetails=new PurchaseDetails();
		Scanner sc =new Scanner(System.in);
		while(true) {
		try {
			System.out.println("-------Menu----------");
			System.out.println("1. Add Purchase Details");
			System.out.println("2. update Mobile Quantity");
			System.out.println("3. View details of Mobile");
			System.out.println("4. Delete mobile details ");
			System.out.println("5. Search Mobile based on price");
			String ch= sc.next();
			
			switch(ch) {
			case "1":
				obj.acceptPuchaseDetails(purchaseDetails);
				try{
	            if(service.validatePurchaseDetail(purchaseDetails)){
	                System.out.println("data added to table......");
				int purchaseid=service.addPurchaseDetail(purchaseDetails);
				System.out.println("Record inserted......"+purchaseid);
	            }
	        }catch(mobileException e){
	         System.err.println(e.getMessage());    
	        }
			break;
			case "2":	
				System.out.println("Enter Mobile id whose quantity is to be changed...");
				int mobileid=sc.nextInt();
				System.out.println("Enter quantity");
				int quantity=sc.nextInt();
				service.updateMobileQty(quantity, mobileid);
				System.out.println("udated quantity....");
				break;
			case "3":
				System.out.println("....Mobile Details are.....");
				ArrayList<MobileDetails> list = service.getAllMobileDetails();
				for(MobileDetails mobDetail:list) {
					System.out.println(mobDetail.getMobileid()+" "+mobDetail.getName()+" "+mobDetail.getPrice()+" "+mobDetail.getQuantity());
				}
				break;
			case "4":
				System.out.println("Enter Mobile Id which is to be deleted...");
				int mobileid1=sc.nextInt();
				System.out.println("working");
				service.deleteRow(mobileid1);
				System.out.println("Mobile row deleted.....");
				break;
			case "5":
				System.out.println("Enter price :");
				int price=sc.nextInt();
				List<MobileDetails> list1=service.searchMobileOnPriceBased(price);
				if(list1.size()==0){
					System.out.println("No Mobile found");
				}else{
					for(MobileDetails md:list1){
						System.out.println("Mobile selected for particular price range"+md);
					}
				}
				break;
			}
		}catch (mobileException e) {
			e.printStackTrace();
		}
	  }
	}

}
