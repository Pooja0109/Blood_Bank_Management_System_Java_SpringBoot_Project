package com.dal.exception;

public class UserDoesNotExistException extends Exception {
	private String message;
    public UserDoesNotExistException(String message) {
        super(message);
        this.message = message;
    }
    public UserDoesNotExistException() {
    	super("ERR :User Does Not Exists...!");
    }
}
