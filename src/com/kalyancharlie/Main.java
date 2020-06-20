package com.kalyancharlie;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		int choice = -1;
		char subChoice = 'Y';
		String name;
		long mobileNumber;
		String emailId;
		String memory;
		ContactServiceImpl conService = new ContactServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("*********************************************");
		System.out.println("           CONTACTS MANAGER V1.0.0");
		System.out.println("*********************************************");
		do {
			System.out.println("\n1. Insert");
			System.out.println("2. Update");
			System.out.println("3. Search");
			System.out.println("4. Display");
			System.out.println("5. Copy");
			System.out.println("6. Copy All");
			System.out.println("0. Exit");
			System.out.print("Enter your choice:");
			choice = sc.nextInt();
			switch(choice) {
			//	INSERTING CONTACTS
			case 1: {
				do {
					System.out.println("******************************************");
					System.out.println("              INSERT MODE");
					System.out.println("******************************************");
					sc.nextLine();
					System.out.print("Enter Name: ");
					name = sc.nextLine();
					System.out.print("Enter Number: ");
					mobileNumber = sc.nextLong(); sc.nextLine();
					System.out.print("Enter EmailId: ");
					emailId = sc.nextLine();
					Contacts con = new Contacts(name, mobileNumber, emailId);
					System.out.println("\nSelect the target Memory");
					System.out.println("1. SIM");
					System.out.println("2. Phone");
					System.out.print("\nEnter your choice:");
					int opt = sc.nextInt();
					if(opt == 1) {
						conService.insertContact(con, "sim");
					} else if (opt == 2) {
						conService.insertContact(con, "phone");
					} else {
						System.out.print("Wrong Option Selected!!!! Try again:");
						opt = sc.nextInt();
						if(opt == 1) {
							conService.insertContact(con, "sim");
						} else if (opt == 2) {
							conService.insertContact(con, "phone");
						}
					}
					System.out.println("Want to Insert Another Contact.");
					System.out.print("Press Y to Proceed and N to Exit Insert Mode: ");
					sc.nextLine();
					subChoice = sc.next().charAt(0);
				} while(subChoice =='y' || subChoice =='Y');
				break;
			}
			//	UPDATING CONTACTS
			case 2: {
				System.out.println("******************************************");
				System.out.println("              UPDATING MODE");
				System.out.println("******************************************");
				break;
				
			}
			//	SEARCHING CONTACTS
			case 3: {
				System.out.println("******************************************");
				System.out.println("              SEARCHING MODE");
				System.out.println("******************************************");
				break;
				
			}
			//	DISPLAYING CONTACTS
			case 4: {
				System.out.println("******************************************");
				System.out.println("              DISPLAYING MODE");
				System.out.println("******************************************");
				conService.display(conService.getSim(), conService.getPhone());
				break;
				
			}
			// COPYING CONTACT
			case 5: {
				System.out.println("******************************************");
				System.out.println("              COPYING MODE");
				System.out.println("******************************************");
				break;
				
			}
			// COPYING ALL CONTACTS
			case 6: {
				System.out.println("******************************************");
				System.out.println("              COPYING MODE");
				System.out.println("******************************************");
				break;
				
			}
			case 0: {				
				System.out.println("\nThank you for using our App.");
				try {
					Thread.sleep(800);
					System.out.println("Exiting");
					Thread.sleep(800);
					choice = 0;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			default: {
				System.out.println("Wrong option selected. Try Again!!!");
				choice = -1;
			}
			}
		}while(choice!=0);
	}
}
