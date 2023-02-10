package com.assignment.spring.service;

import com.assignment.spring.Constants;
import com.assignment.spring.api.CloudsDTO;
import com.assignment.spring.api.CoordDTO;
import com.assignment.spring.api.MainDTO;
import com.assignment.spring.api.SysDTO;
import com.assignment.spring.api.WeatherDTO;
import com.assignment.spring.api.WeatherResponseDTO;
import com.assignment.spring.api.WindDTO;
import com.assignment.spring.entity.WeatherResponseEntity;
import com.assignment.spring.mapper.WeatherResponseMapper;
import com.assignment.spring.repository.WeatherResponseRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private WeatherResponseRepository weatherResponseRepository;

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private EntityManager entityManager;

    @InjectMocks
    private WeatherService weatherService;

    private WeatherResponseDTO weatherResponseDTO;

    private WeatherResponseEntity weatherResponseEntity;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(weatherService, "url", "http://api.openweathermap.org/data/2.5/weather?q=London&APPID=02f6d80d4eb4063b7e1e98ac6b6c5f31");

        weatherResponseDTO = new WeatherResponseDTO();
        weatherResponseDTO.setName("London");

        CoordDTO coordDTO = new CoordDTO();
        coordDTO.setLat(51.5085);
        coordDTO.setLon(-0.1257);

        MainDTO mainDTO = new MainDTO();
        mainDTO.setTemp(279.65);
        mainDTO.setPressure(1036);
        mainDTO.setHumidity(76);

        WindDTO windDTO = new WindDTO();
        windDTO.setSpeed(4.02);
        windDTO.setDeg(180);

        CloudsDTO cloudsDTO = new CloudsDTO();
        cloudsDTO.setAll(100);

        SysDTO sysDTO = new SysDTO();
        sysDTO.setType(2);
        sysDTO.setId(2075535);
        sysDTO.setCountry("GB");
        sysDTO.setSunrise(167);
        sysDTO.setSunset(701);

        WeatherDTO weatherDTO = new WeatherDTO();
        weatherDTO.setId(804);
        weatherDTO.setMain("clouds");
        weatherDTO.setDescription("overcast clouds");
        weatherDTO.setIcon("04d");

        weatherResponseDTO.setClouds(cloudsDTO);
        weatherResponseDTO.setCoord(coordDTO);
        weatherResponseDTO.setMain(mainDTO);
        weatherResponseDTO.setSys(sysDTO);
        weatherResponseDTO.setWeather(List.of(weatherDTO));
        weatherResponseDTO.setWeather(Collections.emptyList());
        weatherResponseDTO.setWind(windDTO);

        weatherResponseEntity = WeatherResponseMapper.mapDtoToEntity(weatherResponseDTO);
        weatherResponseEntity.getWeather().clear();
    }

    @Test
    public void testFetchWeatherData() {
        String city = "London";
        String url = Constants.WEATHER_API_URL.replace("{city}", city).replace("{appid}", "02f6d80d4eb4063b7e1e98ac6b6c5f31");

        when(restTemplate.getForEntity(url, WeatherResponseDTO.class)).thenReturn(ResponseEntity.ok(weatherResponseDTO));

        WeatherResponseDTO result = weatherService.fetchWeatherData(city);

        assertEquals(weatherResponseDTO, result);
        verify(restTemplate, times(1)).getForEntity(url, WeatherResponseDTO.class);
    }

    @Test
    public void testSaveWeatherData() {
        String city = "London";

        when(restTemplate.getForEntity(anyString(), eq(WeatherResponseDTO.class))).thenReturn(ResponseEntity.ok(weatherResponseDTO));

        weatherService.saveWeatherData(city);

        verify(restTemplate, times(1)).getForEntity(anyString(), eq(WeatherResponseDTO.class));
        verify(weatherResponseRepository, times(1)).save(any());
    }

    @Test
    public void testGetWeatherData() {
        String city = "London";

        when(entityManager.createQuery("SELECT w from WeatherResponseEntity w JOIN FETCH w.weather where w.name = :cityName " +
                "ORDER BY w.id DESC", WeatherResponseEntity.class).setParameter("cityName", "London")
                .setMaxResults(1).getSingleResult()).thenReturn(weatherResponseEntity);
        when(weatherResponseRepository.findByName(city)).thenReturn(Optional.of(weatherResponseEntity));

        WeatherResponseDTO result = weatherService.getWeatherData(city);

        assertEquals(weatherResponseDTO.getName(), result.getName());
        assertEquals(weatherResponseDTO.getWeather(), result.getWeather());
    }
}
