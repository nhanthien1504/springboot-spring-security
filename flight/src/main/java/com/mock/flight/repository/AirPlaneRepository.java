package com.mock.flight.repository;

import com.mock.flight.model.AirPlane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirPlaneRepository extends JpaRepository<AirPlane, Long> {

    //@Query(value = "select * from airplane where airplane_code = ? and aircraft_type = ?", nativeQuery = true)
    List<AirPlane>findByAirCraftTypeAndAirPlaneCode(String airCraftType, String airPlaneCode);



}
