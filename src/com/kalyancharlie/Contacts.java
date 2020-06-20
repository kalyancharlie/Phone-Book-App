package com.kalyancharlie;

public class Contacts {
	String name;
	long mobileNumber;
	String emailId;
	
	public Contacts() {
		
	}
	
	public Contacts(String name, long mobileNumber, String emailId) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Contacts [name=" + name + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + "]";
	}
}
