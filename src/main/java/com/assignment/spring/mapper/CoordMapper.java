package com.assignment.spring.mapper;

import com.assignment.spring.api.CoordDTO;
import com.assignment.spring.entity.CoordEntity;

public class CoordMapper {

    public static CoordEntity mapDtoToEntity(final CoordDTO coordDTO) {
        return CoordEntity.builder()
                .lon(coordDTO.getLon())
                .lat(coordDTO.getLat())
                .build();
    }

    public static CoordDTO mapEntityToDto(final CoordEntity coordEntity) {
        return CoordDTO.builder()
                .lon(coordEntity.getLon())
                .lat(coordEntity.getLat())
                .build();
    }
}
