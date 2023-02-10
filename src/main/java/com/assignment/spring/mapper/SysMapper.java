package com.assignment.spring.mapper;

import com.assignment.spring.api.SysDTO;
import com.assignment.spring.entity.SysEntity;

public class SysMapper {

    public static SysEntity mapDtoToEntity(final SysDTO sysDTO) {
        return SysEntity.builder()
                .type(sysDTO.getType())
                .id(sysDTO.getId())
                .message(sysDTO.getMessage())
                .country(sysDTO.getCountry())
                .sunset(sysDTO.getSunset())
                .sunrise(sysDTO.getSunrise())
                .build();
    }

    public static SysDTO mapEntityToDto(final SysEntity sysEntity) {
        return SysDTO.builder()
                .type(sysEntity.getType())
                .id(sysEntity.getId())
                .message(sysEntity.getMessage())
                .country(sysEntity.getCountry())
                .sunset(sysEntity.getSunset())
                .sunrise(sysEntity.getSunrise())
                .build();
    }
}
