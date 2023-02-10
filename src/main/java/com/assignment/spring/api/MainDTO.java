
package com.assignment.spring.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MainDTO {

    private Double temp;
    private Integer pressure;
    private Integer humidity;
    private Double tempMin;
    private Double tempMax;

}
