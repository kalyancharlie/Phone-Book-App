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
			System.out.print("\nEnter your choice:");
			choice = sc.nextInt();
			switch(choice) {
			//	INSERTING CONTACTS
			case 1: {
				do {
					System.out.println("******************************************");
					System.out.println("              INSERT MODE");
					System.out.println("******************************************");
					sc.nextLine();
					System.out.print("\nEnter Name: ");
					name = sc.nextLine();
					System.out.print("Enter Number: ");
					mobileNumber = sc.nextLong(); sc.nextLine();
					System.out.print("Enter EmailId: ");
					emailId = sc.next();
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
						System.out.print("Wrong Option Selected!!!!");
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
				do {
					System.out.println("******************************************");
					System.out.println("              UPDATING MODE");
					System.out.println("******************************************");
					System.out.println("\nSelect the Update Method");
					System.out.println("1. By name");
					System.out.println("2. By number");
					System.out.print("\nEnter your choice:");
					int opt = sc.nextInt();
					if(opt == 1) {
						sc.nextLine();
						System.out.print("\nEnter Name of contact to find: ");
						String nameToSearch = sc.nextLine();
						System.out.print("Enter Memory location (SIM/PHONE): ");
						String memoryToFind = sc.next();
						Contacts find = conService.searchContact(nameToSearch, memoryToFind);
						System.out.println("\nEnter 0 if you don't want to update particular field\n");
						if(find!=null) {
							sc.nextLine();
							System.out.print("Enter the New Name: ");
							name = sc.nextLine();
							System.out.print("Enter the New Number: ");
							mobileNumber = sc.nextLong(); sc.nextLine();
							System.out.print("Enter the new EmailId: ");
							emailId = sc.next();
							if(name.equals("0")) name = find.name;
							if(mobileNumber == 0) mobileNumber = find.mobileNumber;
							if(emailId.equals("0")) emailId = find.emailId;
							Contacts updated = new Contacts(name, mobileNumber, emailId);
							conService.updateContact(find, updated, memoryToFind);
						}
					} else if (opt == 2) {
						sc.nextLine();
						System.out.print("Enter Number: ");
						long numberToSearch = sc.nextLong(); sc.nextLine();
						System.out.print("Enter Memory Location (SIM/PHONE): ");
						String memoryToFind = sc.next();
						Contacts find = conService.searchContact(numberToSearch, memoryToFind);
						if(find!=null) {
							sc.nextLine();
							System.out.print("Enter the New Name: ");
							name = sc.nextLine();
							System.out.print("Enter the New Number: ");
							mobileNumber = sc.nextLong(); sc.nextLine();
							System.out.print("Enter the new EmailId: ");
							emailId = sc.next();
							if(name.equals("0")) name = find.name;
							if(mobileNumber == 0) mobileNumber = find.mobileNumber;
							if(emailId.equals("0")) emailId = find.emailId;
							Contacts updated = new Contacts(name, mobileNumber, emailId);
							conService.updateContact(find, updated, memoryToFind);
						}
					} else {
						System.out.print("Wrong Option Selected!!!!");
					}
					System.out.println("Want to Update Another Contact.");
					System.out.print("Press Y to Proceed and N to Exit Insert Mode: ");
					subChoice = sc.next().charAt(0);
				} while(subChoice =='y' || subChoice =='Y');
				break;				
			}
			//	SEARCHING CONTACTS
			case 3: {
				do {
					System.out.println("******************************************");
					System.out.println("              SEARCHING MODE");
					System.out.println("******************************************");
					System.out.println("\nSelect the Search Method");
					System.out.println("1. By name");
					System.out.println("2. By number");
					System.out.print("\nEnter your choice:");
					int opt = sc.nextInt();
					if(opt == 1) {
						sc.nextLine();
						System.out.print("Enter Name: ");
						String nameToSearch = sc.nextLine();
						System.out.print("Enter Memory location (SIM/PHONE): ");
						String memoryToFind = sc.next();
						Contacts find = conService.searchContact(nameToSearch, memoryToFind);
						if(find!=null)
						System.out.println("\nName: "+find.name+", Mobile: "+find.mobileNumber+", EmailId: "+find.emailId+"\n");
					} else if (opt == 2) {
						sc.nextLine();
						System.out.print("Enter Number: ");
						long numberToSearch = sc.nextLong();
						sc.nextLine();
						System.out.print("Enter Memory Location (SIM/PHONE): ");
						String memoryToFind = sc.next();
						Contacts find = conService.searchContact(numberToSearch, memoryToFind);
						if(find!=null)
						System.out.println("\nName: "+find.name+" Mobile: "+find.mobileNumber+" EmailId: "+find.emailId+"\n");
					} else {
						System.out.print("Wrong Option Selected!!!!");
					}
					System.out.println("Want to Search Another Contact.");
					System.out.print("Press Y to Proceed and N to Exit Insert Mode: ");
					subChoice = sc.next().charAt(0);
				} while(subChoice =='y' || subChoice =='Y');
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
