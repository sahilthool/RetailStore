package Presentation;

import java.util.HashSet;

import java.util.Optional;
import java.util.Scanner;

import Bean.Customer;
import Service.allitemServiceImpl;
import Service.customerServiceImpl;
import Service.generate_billServiceImpl;
import Service.transactionDetailsServiceImpl;
import Service.transactionServiceImpl;


public class PresentationImpl implements Presentation {

	
	@Override
	public void showMenu() {
		System.out.println("1. Add To Cart");
		System.out.println("2. Generate Bill");
		System.out.println("3. Show All Items");
		System.out.println("4. Show All Transactions");
		System.out.println("5. Show All Transactions Details");
		System.out.println("6. Show All Customers");
		System.out.println("7. Exit");
		

	}
	

	@Override
	public void performMenu(int choice) {
		
		customerServiceImpl cs=new customerServiceImpl();
		
		Scanner scanner = new Scanner(System.in);
		try {
			switch (choice) {
			case 1:
				
				
				break;

			case 2:
				generate_billServiceImpl gb=new generate_billServiceImpl();
				System.out.println("Enter Customer_id");
				int cust_id=scanner.nextInt();
				gb.generate_bill(cust_id);
				System.out.println("Bill:");
				
				break;

			case 3:
				System.out.println("Showing All Items:");
				allitemServiceImpl item=new allitemServiceImpl();
				item.showallitem();
				break;
			
			case 4:
				System.out.println("Showing all Transactions:");
				transactionServiceImpl ts=new transactionServiceImpl();
				ts.showalltransactions();
				break;
				
			case 5:
				System.out.println(" Showing all Transaction Details:");
				transactionDetailsServiceImpl tds=new transactionDetailsServiceImpl();
				tds.showalltransactionDetails();
				break;
			case 6:
				System.out.println("Showing all customers");
				customerServiceImpl css=new customerServiceImpl();
				css.showCustomer();
				break;
			case 7:
				System.out.println("Thanks for Visiting Our Store.");
				System.exit(0);
			default:
				System.out.println("Invalid Coice");
				break;
				
				
			}
			

			
		} catch (Exception exception) {

		}

	}
     @Override
	public void login()
	{
		System.out.println("Login");
		System.out.println("Enter customer_id");
		Scanner scanner = new Scanner(System.in);
		int cid=scanner.nextInt();
		customerServiceImpl cs=new customerServiceImpl();

		if(cs.searchCustomer(cid)) {
			System.out.println("loginSuccessful");
			while(true) {
		    showMenu();
		    int choice;
		    System.out.println("enter choice");
		    choice=scanner.nextInt();
		    performMenu(choice);}}
		else
		{
			System.out.println("Enter Name");
		    String name=scanner.nextLine();
		    System.out.println("Enter Username");
		    String username=scanner.nextLine();
		    System.out.println("Enter Password");
		    String password=scanner.nextLine();
		    Customer cust=new Customer(cid,name,username,password);
		    cs.addCustomer(cust);
		    System.out.println("Registration Successfull :)");
		    System.out.println("Login Now");
		    login();
		}
	}
}
