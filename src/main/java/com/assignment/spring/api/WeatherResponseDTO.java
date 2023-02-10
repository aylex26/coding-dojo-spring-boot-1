
package com.assignment.spring.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherResponseDTO {

    private CoordDTO coord;
    private List<WeatherDTO> weather = null;
    private String base;
    private MainDTO main;
    private Integer visibility;
    private WindDTO wind;
    private CloudsDTO clouds;
    private Integer dt;
    private SysDTO sys;
    private Integer id;
    private String name;
    private Integer cod;


    public void setCity(String london) {
    }
}
