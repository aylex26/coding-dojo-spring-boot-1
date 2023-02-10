package com.assignment.spring.repository;

import com.assignment.spring.entity.WeatherResponseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WeatherResponseRepository extends CrudRepository<WeatherResponseEntity, Integer> {

    @Query("SELECT w from WeatherResponseEntity w JOIN FETCH w.weather where w.name = :cityName ORDER BY w.id DESC")
    Optional<WeatherResponseEntity> findByName(String cityName);
}
