package com.kalyancharlie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ContactServiceImpl implements ContactService {
	ArrayList<Contacts> sim = new ArrayList<Contacts>();
	ArrayList<Contacts> phone = new ArrayList<Contacts>();
	
	public ContactServiceImpl() {
		
	}

	public ArrayList<Contacts> getSim() {
		return sim;
	}

	public ArrayList<Contacts> getPhone() {
		return phone;
	}
	
	@Override
	public void insertContact(Contacts contact, String memory) {
		boolean flag = true;
		if(memory.equalsIgnoreCase("sim"))
		for(int i=0; i<sim.size(); i++) {
			if(sim.get(i).name.equalsIgnoreCase(contact.name)) {
				flag = false;
			}
		}
		if(memory.equalsIgnoreCase("phone"))
		for(int i=0; i<phone.size(); i++) {
			if(phone.get(i).name.equalsIgnoreCase(contact.name)) {
				flag = false;
			}
		}
		if(!flag) {
			System.out.println("\nContact with name " + contact.name + " already exists in " +memory+"\n");
		}
		if(memory.toLowerCase().equals("sim") && flag) {
			sim.add(contact);
			System.out.println("\nContact " + contact.name +" Inserted Successfully into SIM\n");
		} else if (memory.toLowerCase().equals("phone") && flag) {
			phone.add(contact);
			System.out.println("\nContact " + contact.name +" Inserted Successfully into PHONE\n");
		}
		
	}

	@Override
	public void updateContact(Contacts old, Contacts updated, String memory) {
		Contacts found = searchContact(old.name, memory);
		if(memory.toLowerCase().equals("sim")) {
			for(int i=0; i<sim.size(); i++) {
				if(sim.get(i).equals(found)) {
					sim.set(i, updated);
					System.out.println("Contact Updated Successfully");
				}
			}
		} else if(memory.toLowerCase().equals("phone")) {
			for(int i=0; i<sim.size(); i++) {
				if(phone.get(i).equals(found)) {
					phone.set(i, updated);
					System.out.println("Contact Updated Successfully");
				}
			}
		}
	}

	@Override
	public Contacts searchContact(String name, String memory) {
		if(memory.toLowerCase().equals("sim")) {
			for(int i=0; i<sim.size(); i++) {
				if(sim.get(i).name.toLowerCase().equals(name)) {
					return sim.get(i);
				}
			}
			System.out.println("No Contact found with the name: "+name.toUpperCase());
			return null;
		} else if(memory.toLowerCase().equals("phone")) {
			for(int i=0; i<phone.size(); i++) {
				if(phone.get(i).name.toLowerCase().equals(name)) {
					return phone.get(i);
				}
			}
			System.out.println("No Contact found with the name: "+name.toUpperCase());
			return null;
		}
		return null;
	}

	@Override
	public Contacts searchContact(long mobileNumber, String memory) {
		if(memory.toLowerCase().equals("sim")) {
			for(int i=0; i<sim.size(); i++) {
				if(sim.get(i).mobileNumber == mobileNumber) {
					return sim.get(i);
				}
			}
			return null;
		} else if(memory.toLowerCase().equals("phone")) {
			for(int i=0; i<phone.size(); i++) {
				if(phone.get(i).mobileNumber == mobileNumber) {
					return phone.get(i);
				}
			}
			return null;
		}
		return null;
	}

	@Override
	public void display(ArrayList<Contacts> sim, ArrayList<Contacts> phone) {
		boolean flag = true;
		if(sim==null && phone==null || sim.size()<1 && phone.size()<1) {
			System.out.println("No Contacts in memory. Add Contacts to display them");
			flag = false;
			return;
		}
		ArrayList<Contacts> both = new ArrayList<Contacts>();
		Map<String, Integer> all = new HashMap<String, Integer>();
		if(sim!=null) {
			for(int i=0; i<sim.size(); i++) {
				both.add(sim.get(i));
			}
		} if (phone!=null) {
			for(int i=0; i<phone.size(); i++) {
				both.add(phone.get(i));
			}
		}
		
		for(int i=0; i<both.size(); i++) {
			all.put(both.get(i).name, i );
		}
		for(int i=0, j=0; i<both.size(); i++) {
			if(i==all.get(both.get(i).name)) {
				System.out.println(++j+". "+both.get(i));
			}
		}
		if(flag) {
			System.out.println("\n			End of Contacts!");
			System.out.println("*********************************************");
		}
	}

	@Override
	public void copy(Contacts contact, String target) {
		if(target.equalsIgnoreCase("sim")) {
			if(!sim.contains(contact)) {
				sim.add(contact);
			}
		} else if(target.equalsIgnoreCase("phone")) {
			if(!phone.contains(contact)) {
				phone.add(contact);
			}
		}
		System.out.println("Contact Copied Successfully");
	}

	@Override
	public void copyAll(ArrayList<Contacts> contact, String target) {
		if(target.equalsIgnoreCase("sim")) {
			for(int i=0; i<contact.size(); i++) {
				if(!sim.contains(contact.get(i))) {
					sim.add(contact.get(i));
				}
			}
		} else if(target.equalsIgnoreCase("phone")) {
			for(int i=0; i<contact.size(); i++) {
				if(!phone.contains(contact.get(i))) {
					phone.add(contact.get(i));
				}
			}
		}
		System.out.println("Contacts Copied Successfully");
	}	
}
