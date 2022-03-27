package com.mock.flight.model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "certificate")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "airplane_code")
    private String airplaneCode;

    @Column(name = "staff_code")
    private String staffCode;

    @Override
    public String toString() {
        return "certificate{" +
                "staffCode='" + staffCode + '\'' +
                ", airplaneCode='" + airplaneCode + '\'' +
                '}';
    }
}
