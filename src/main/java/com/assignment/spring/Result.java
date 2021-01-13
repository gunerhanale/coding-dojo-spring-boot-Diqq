package com.assignment.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class Result {
	
	private String resultMessage;
	private String resultCode;
	
	@Autowired
	private WeatherEntity weatherEntity;
	
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

	public WeatherEntity getWeatherEntity() {
		return weatherEntity;
	}

	public void setWeatherEntity(WeatherEntity weatherEntity) {
		this.weatherEntity = weatherEntity;
	}
	
}
