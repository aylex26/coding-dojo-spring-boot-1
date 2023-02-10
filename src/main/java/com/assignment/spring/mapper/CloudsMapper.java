package com.assignment.spring.mapper;

import com.assignment.spring.api.CloudsDTO;
import com.assignment.spring.entity.CloudsEntity;

public class CloudsMapper {

    public static CloudsEntity mapDtoToEntity(final CloudsDTO cloudsDTO) {
        return CloudsEntity.builder()
                .all(cloudsDTO.getAll())
                .build();
    }

    public static CloudsDTO mapEntityToDto(final CloudsEntity cloudsEntity) {
        return CloudsDTO.builder()
                .all(cloudsEntity.getAll())
                .build();
    }
}
