package com.assignment.spring.mapper;

import com.assignment.spring.api.WeatherResponseDTO;
import com.assignment.spring.entity.WeatherResponseEntity;

import java.util.stream.Collectors;

public class WeatherResponseMapper {

    public static WeatherResponseEntity mapDtoToEntity(final WeatherResponseDTO weatherResponseDTO) {
        return WeatherResponseEntity.builder()
                .coord(CoordMapper.mapDtoToEntity(weatherResponseDTO.getCoord()))
                .weather(weatherResponseDTO.getWeather().stream().map(WeatherMapper::mapDtoToEntity).collect(Collectors.toList()))
                .base(weatherResponseDTO.getBase())
                .main(MainMapper.mapDtoToEntity(weatherResponseDTO.getMain()))
                .visibility(weatherResponseDTO.getVisibility())
                .wind(WindMapper.mapDtoToEntity(weatherResponseDTO.getWind()))
                .clouds(CloudsMapper.mapDtoToEntity(weatherResponseDTO.getClouds()))
                .dt(weatherResponseDTO.getDt())
                .sys(SysMapper.mapDtoToEntity(weatherResponseDTO.getSys()))
                .id(weatherResponseDTO.getId())
                .name(weatherResponseDTO.getName())
                .cod(weatherResponseDTO.getCod())
                .build();
    }

    public static WeatherResponseDTO mapEntityToDto(final WeatherResponseEntity weatherResponseEntity) {
        return WeatherResponseDTO.builder()
                .coord(CoordMapper.mapEntityToDto(weatherResponseEntity.getCoord()))
                .weather(weatherResponseEntity.getWeather().stream().map(WeatherMapper::mapEntityToDto).collect(Collectors.toList()))
                .base(weatherResponseEntity.getBase())
                .main(MainMapper.mapEntityToDto(weatherResponseEntity.getMain()))
                .visibility(weatherResponseEntity.getVisibility())
                .wind(WindMapper.mapEntityToDto(weatherResponseEntity.getWind()))
                .clouds(CloudsMapper.mapEntityToDto(weatherResponseEntity.getClouds()))
                .dt(weatherResponseEntity.getDt())
                .sys(SysMapper.mapEntityToDto(weatherResponseEntity.getSys()))
                .id(weatherResponseEntity.getId())
                .name(weatherResponseEntity.getName())
                .cod(weatherResponseEntity.getCod())
                .build();
    }
}
