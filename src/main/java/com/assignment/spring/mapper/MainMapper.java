package com.assignment.spring.mapper;

import com.assignment.spring.api.MainDTO;
import com.assignment.spring.entity.MainEntity;

public class MainMapper {

    public static MainEntity mapDtoToEntity(final MainDTO mainDTO) {
        return MainEntity.builder()
                .temp(mainDTO.getTemp())
                .pressure(mainDTO.getPressure())
                .humidity(mainDTO.getHumidity())
                .tempMin(mainDTO.getTempMin())
                .tempMax(mainDTO.getTempMax())
                .build();
    }

    public static MainDTO mapEntityToDto(final MainEntity mainEntity) {
        return MainDTO.builder()
                .temp(mainEntity.getTemp())
                .pressure(mainEntity.getPressure())
                .humidity(mainEntity.getHumidity())
                .tempMin(mainEntity.getTempMin())
                .tempMax(mainEntity.getTempMax())
                .build();
    }
}
