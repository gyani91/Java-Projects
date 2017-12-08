package com.psl;

public class InvalidDateFormatException extends Exception {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public InvalidDateFormatException() {
	super("Invalid Date format ");
}
public InvalidDateFormatException(String msg) {
	super(msg);
}
}
