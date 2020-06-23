package com.kalyancharlie;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kalyancharlie.exceptions.InvalidEmailException;
import com.kalyancharlie.exceptions.InvalidMobileNumberException;

@SuppressWarnings("serial")
public class Contacts implements Serializable{
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

	public void setMobileNumber(long mobileNumber) throws InvalidMobileNumberException {
		if(String.valueOf(mobileNumber).length()!=10) {
			throw new InvalidMobileNumberException("Invalid Mobile Number:"+mobileNumber);
		} else {
			this.mobileNumber = mobileNumber;
		}
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) throws InvalidEmailException {
		boolean flag = false;
		Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_.]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
		Matcher m = p.matcher(emailId);
		while(m.find()) {
			flag = true;
		}
		if(flag)
		this.emailId = emailId;
		else throw new InvalidEmailException("Invalid Email Id: "+emailId);
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Mobile: " + mobileNumber + ", EmailId: " + emailId;
	}
}
