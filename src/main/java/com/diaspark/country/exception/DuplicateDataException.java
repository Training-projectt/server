package com.diaspark.country.exception;

public class DuplicateDataException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateDataException(String message) {

		super(message);
	}
}