package com.mock.flight.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "airplane")
public class AirPlane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "airplane_code")
    private String airPlaneCode;

    @Column(name = "aircraft_type")
    private String airCraftType;

    @Column(name = "flying_range")
    private int flyingRange;


    @Override
    public String toString() {
        return "AirPlane{" +
                "airplaneCode='" + airPlaneCode + '\'' +
                ", aircraftType='" + airCraftType + '\'' +
                ", flyingRange='" + flyingRange + '\'' +
                '}';
    }


}