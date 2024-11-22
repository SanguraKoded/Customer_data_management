package com.sangura.CustomerData.Exceptions;

public class InvalidCustomerIdException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCustomerIdException (String message) {
		super(message);
	}

}
