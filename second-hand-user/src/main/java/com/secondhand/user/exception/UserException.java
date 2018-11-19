package com.secondhand.user.exception;

public class UserException extends RuntimeException{
	UserException(String message,Throwable cause){
		super(message,cause);
	}
	UserException(String message){
		super(message);
	}
}
