package com.assignment.spring.mapper;

import com.assignment.spring.api.WeatherDTO;
import com.assignment.spring.entity.WeatherEntity;

public class WeatherMapper {

    public static WeatherEntity mapDtoToEntity(final WeatherDTO weatherDTO) {
        return WeatherEntity.builder()
                .id(weatherDTO.getId())
                .main(weatherDTO.getMain())
                .description(weatherDTO.getDescription())
                .icon(weatherDTO.getIcon())
                .build();
    }

    public static WeatherDTO mapEntityToDto(final WeatherEntity weatherEntity) {
        return WeatherDTO.builder()
                .id(weatherEntity.getId())
                .main(weatherEntity.getMain())
                .description(weatherEntity.getDescription())
                .icon(weatherEntity.getIcon())
                .build();
    }
}
