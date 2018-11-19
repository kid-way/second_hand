package com.secondhand.user.exception;

public class ProductStockException extends RuntimeException{
	public ProductStockException(String message){
		super(message);
	}
	public ProductStockException(String message,Throwable cause){
		super(message, cause);
	}
}
