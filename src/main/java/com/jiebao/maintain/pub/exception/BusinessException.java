package com.jiebao.maintain.pub.exception;

public class BusinessException extends RuntimeException  {
	private String code = "1000";

	public BusinessException() {
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(Throwable cause, String code) {
		super(cause);
		this.code = code;
	}

	public BusinessException(String message, String code) {
		super(message);
		this.code = code;
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message, Throwable cause, String code) {
		super(message, cause);
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
