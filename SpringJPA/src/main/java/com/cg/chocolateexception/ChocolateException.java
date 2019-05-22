package com.cg.chocolateexception;

public class ChocolateException extends RuntimeException {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ChocolateException(String message) {

		this.message = message;
	}

}
