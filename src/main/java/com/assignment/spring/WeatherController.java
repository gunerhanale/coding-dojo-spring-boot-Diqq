package com.assignment.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.assignment.spring.api.WeatherResponse;

@RestController
public class WeatherController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WeatherRepository weatherRepository;

	@SuppressWarnings("finally")
	@RequestMapping("/weather")
	public Result weather(HttpServletRequest request) {

		Result result = new Result("Data saved successfully in Database.", "SUCCESS");

		String city = request.getParameter("city");

		// added variable below to fetch it as a environment variable
		String appid = request.getParameter("appid");

		String url = Constants.WEATHER_API_URL.replace("{city}", city).replace("{appid}", appid);

		// If It works without error, try and finally blocks will work and is ended
		// process. Otherwise Try, Catch and finally blocks will will work by order...
		try {
			ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(url, WeatherResponse.class);
			result.setWeatherEntity(mapper(response.getBody()));

		} catch (Exception e) {
			result.setResultMessage(Constants.INTERNAL_SERVER_ERROR);
			result.setResultCode("INTERNAL_SERVER_ERROR");
			result.setWeatherEntity(null);
		} finally {
			return result;
		}
	}

	private WeatherEntity mapper(WeatherResponse response) {
		WeatherEntity entity = new WeatherEntity();
		entity.setCity(response.getName());
		entity.setCountry(response.getSys().getCountry());
		entity.setTemperature(response.getMain().getTemp());

		return weatherRepository.save(entity);
	}
}
