package com.kalyancharlie.exceptions;

@SuppressWarnings("serial")
public class InvalidEmailException extends Exception {
	public InvalidEmailException(String msg) {
		super(msg);
	}
}
