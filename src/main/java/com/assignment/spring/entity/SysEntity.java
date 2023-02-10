package com.assignment.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys")
public class SysEntity {

    @Id
    @Column(name = "sys_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sysId;
    @Column
    private Integer type;
    @Column
    private Integer id;
    @Column
    private Double message;
    @Column
    private String country;
    @Column
    private Integer sunrise;
    @Column
    private Integer sunset;

    @OneToOne
    @JoinColumn(name = "weather_response_id")
    private WeatherResponseEntity weatherResponseEntity;
}
