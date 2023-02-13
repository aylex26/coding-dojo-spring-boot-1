package com.assignment.spring.service;

import com.assignment.spring.api.WeatherResponseDTO;
import com.assignment.spring.entity.WeatherResponseEntity;
import com.assignment.spring.mapper.WeatherResponseMapper;
import com.assignment.spring.repository.WeatherResponseRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Data
public class WeatherService {

    @PersistenceContext
    private EntityManager entityManager;

    @Value("${configuration.open-weather.url}")
    private String url;

    private final RestTemplate restTemplate;

    private final WeatherResponseRepository weatherResponseRepository;

    public WeatherResponseDTO fetchWeatherData(final String city) throws RestClientException {
        String urlWithCity = getUrl().replace("{city}", city);
        ResponseEntity<WeatherResponseDTO> response = restTemplate.getForEntity(urlWithCity, WeatherResponseDTO.class);
        return response.getBody();
    }

    public void saveWeatherData(final String city) {
        WeatherResponseDTO weatherResponseDTO = fetchWeatherData(city);
        WeatherResponseEntity weatherResponseEntity = WeatherResponseMapper.mapDtoToEntity(weatherResponseDTO);

        weatherResponseEntity.getClouds().setWeatherResponseEntity(weatherResponseEntity);
        weatherResponseEntity.getCoord().setWeatherResponseEntity(weatherResponseEntity);
        weatherResponseEntity.getMain().setWeatherResponseEntity(weatherResponseEntity);
        weatherResponseEntity.getSys().setWeatherResponseEntity(weatherResponseEntity);
        weatherResponseEntity.getWind().setWeatherResponseEntity(weatherResponseEntity);
        weatherResponseEntity.getWeather().stream().map(weatherEntity -> {
            weatherEntity.setWeatherResponseEntity(weatherResponseEntity);
            return weatherEntity;
        }).collect(toList());
        weatherResponseRepository.save(weatherResponseEntity);
    }

    public WeatherResponseDTO getWeatherData(final String city) {
        try {
            WeatherResponseEntity weatherResponseEntity = entityManager.createQuery(
                            "SELECT w from WeatherResponseEntity w JOIN FETCH w.weather where w.name = :cityName " +
                                    "ORDER BY w.id DESC", WeatherResponseEntity.class)
                    .setParameter("cityName", city)
                    .setMaxResults(1)
                    .getSingleResult();
            return WeatherResponseMapper.mapEntityToDto(weatherResponseEntity);
        } catch (NoResultException e) {
            throw new EntityNotFoundException("There is no weather data for this location");
        }
    }
}
