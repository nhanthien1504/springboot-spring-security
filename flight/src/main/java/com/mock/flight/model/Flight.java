package com.mock.flight.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "flight_code")
    private String flightCode;

    @Column(name = "depart_station")
    private String departStation;

    @Column(name = "arrive_at_station")
    private String arriveAtStation;

    @Column(name = "departure_time")
    private String departureTime;

    @Column(name = "end_time")
    private String endTime;

    @Column(name = "flying_range")
    private int flyingRange;

    @Column(name = "price")
    private int price;

}
