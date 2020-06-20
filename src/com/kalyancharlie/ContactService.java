package com.kalyancharlie;
import java.util.ArrayList;

public interface ContactService {	
	public void insertContact(Contacts contact, String memory);
	public void updateContact(Contacts old, Contacts updated, String memory);
	public Contacts searchContact(String name, String memory);
	public Contacts searchContact(long mobileNumber, String memory);
	public void display(ArrayList<Contacts> sim, ArrayList<Contacts> phone);
	public void copy(Contacts contact, String target );
	public void copyAll(ArrayList<Contacts> contact, String target);
}
