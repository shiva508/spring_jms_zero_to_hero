package com.pool.model;

public class CommonResponse {
	private String message;
	private Integer statusCode;

	public CommonResponse() {
	}

	public String getMessage() {
		return message;
	}

	public CommonResponse setMessage(String message) {
		this.message = message;
		return this;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public CommonResponse setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	@Override
	public String toString() {
		return "CommonResponse [message=" + message + ", statusCode=" + statusCode + "]";
	}

}
