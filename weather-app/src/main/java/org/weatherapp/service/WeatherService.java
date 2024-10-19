package org.weatherapp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final String API_KEY = "bcf115df22adff6a15148ebbba24542a"; 
    private final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

    public String getWeatherData(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(API_URL, city, API_KEY);
         
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            return "Error: " + response.getStatusCode() + " - " + response.getBody();
        }
    }
}