package com.kalyancharlie;

public interface ContactService {	
	public void insertContact(Contacts contact, String memory);
	public void updateContact(Contacts contact, String memory);
	public Contacts searchContact(String name, String memory);
	public Contacts searchContact(long mobileNumber, String memory);
}
