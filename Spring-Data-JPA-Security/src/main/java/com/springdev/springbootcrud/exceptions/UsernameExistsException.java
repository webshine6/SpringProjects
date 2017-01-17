package com.springdev.springbootcrud.exceptions;

public class UsernameExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public UsernameExistsException(String message) {
		super(message);
	}
}
