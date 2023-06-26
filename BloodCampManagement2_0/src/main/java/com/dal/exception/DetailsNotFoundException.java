package com.dal.exception;

public class DetailsNotFoundException extends Exception {
	private String message;
    public DetailsNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public DetailsNotFoundException() {
    	super("ERR :Details Not Found...!");
    }
}
