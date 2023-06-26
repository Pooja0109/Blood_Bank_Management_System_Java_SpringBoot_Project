package com.dal.exception;

public class CampNotFoundException extends Exception {
	private String message;
    public CampNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public CampNotFoundException() {
    	super("ERR :Camp Details Not Found...!");
    }
}
