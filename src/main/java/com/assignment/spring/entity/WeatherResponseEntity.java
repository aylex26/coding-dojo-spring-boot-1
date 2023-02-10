package com.assignment.spring.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "weather_response")
public class WeatherResponseEntity {

    @Id
    @Column(name = "weather_response_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer weatherResponseId;

    @OneToOne(mappedBy = "weatherResponseEntity", cascade = CascadeType.ALL)
    private CoordEntity coord;
    @JsonManagedReference
    @OneToMany(mappedBy = "weatherResponseEntity", cascade = {CascadeType.ALL})
    private List<WeatherEntity> weather = new ArrayList<>();
    @OneToOne(mappedBy = "weatherResponseEntity", cascade = CascadeType.ALL)
    private MainEntity main;
    @OneToOne(mappedBy = "weatherResponseEntity", cascade = CascadeType.ALL)
    private WindEntity wind;
    @OneToOne(mappedBy = "weatherResponseEntity", cascade = CascadeType.ALL)
    private CloudsEntity clouds;
    @OneToOne(mappedBy = "weatherResponseEntity", cascade = CascadeType.ALL)
    private SysEntity sys;
    @Column
    private String base;
    @Column
    private Integer dt;
    @Column
    private Integer visibility;
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer cod;


}
