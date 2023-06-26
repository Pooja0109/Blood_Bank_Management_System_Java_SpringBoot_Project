package com.dal.exception;

public class CampAlreadyExistException extends Exception {
	private String message;
    public CampAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }
    public CampAlreadyExistException() {
    	super("ERR :Camp Details Already Exist...!");
    }

}
