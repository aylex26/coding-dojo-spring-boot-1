package com.assignment.spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "weather")
public class WeatherEntity {

    @Id
    @Column(name = "weather_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer weatherId;
    @Column
    private Integer id;
    @Column
    private String main;
    @Column
    private String description;
    @Column
    private String icon;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "weather_response_id")
    private WeatherResponseEntity weatherResponseEntity;

}
