package com.assignment.spring;

public class Constants {

// we made it parametric request in WeatherConroller
//    public static final String APP_ID = "TBD";
	
	public static final String INTERNAL_SERVER_ERROR = "Something went wrong, possibly the related service could not be reached!";

    public static final String WEATHER_API_URL = "http://api.openweathermap.org/data/2.5/weather?q={city}&APPID={appid}";
}
