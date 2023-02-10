package com.assignment.spring.controller;

import com.assignment.spring.api.WeatherResponseDTO;
import com.assignment.spring.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @PostMapping("/weather")
    public void fetchWeather(@RequestParam("city") final String city) {
        weatherService.saveWeatherData(city);
    }

    @GetMapping("/weather")
    public WeatherResponseDTO getWeather(@RequestParam("city") final String city) {
        return weatherService.getWeatherData(city);
    }
}
