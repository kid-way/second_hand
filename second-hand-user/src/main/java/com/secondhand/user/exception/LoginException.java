package com.secondhand.user.exception;

public class LoginException extends UserException{
	public LoginException(String message) {
		super(message);
	}
	public LoginException(String message,Throwable cause){
		super(message,cause);
	}
}
