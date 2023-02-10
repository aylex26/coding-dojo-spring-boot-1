package com.assignment.spring.mapper;

import com.assignment.spring.api.WindDTO;
import com.assignment.spring.entity.WindEntity;

public class WindMapper {

    public static WindEntity mapDtoToEntity(final WindDTO windDTO) {
        return WindEntity.builder()
                .speed(windDTO.getSpeed())
                .deg(windDTO.getDeg())
                .build();
    }

    public static WindDTO mapEntityToDto(final WindEntity windEntity) {
        return WindDTO.builder()
                .speed(windEntity.getSpeed())
                .deg(windEntity.getDeg())
                .build();
    }
}
