package com.assignment.spring;

public class Result {
	
	private String resultMessage;
	private String resultCode;
	
	public Result(String resultMessage, String resultCode) {
		this.resultMessage = resultMessage;
		this.resultCode = resultCode;
	}
	
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	
	

}
