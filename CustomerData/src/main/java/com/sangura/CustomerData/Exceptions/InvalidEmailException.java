package com.sangura.CustomerData.Exceptions;

public class InvalidEmailException extends RuntimeException{
	

	private static final long serialVersionUID = 1L;

	public InvalidEmailException (String message) {
		super(message);
	}

}
