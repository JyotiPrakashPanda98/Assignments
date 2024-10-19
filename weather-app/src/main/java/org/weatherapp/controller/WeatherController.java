package org.weatherapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@RestController
public class WeatherController {
    private static final String API_KEY = "bcf115df22adff6a15148ebbba24542a"; // 
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";

    @GetMapping("/weather")
    public ResponseEntity<String> getWeather(@RequestParam String city) {
        String url = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }
}
