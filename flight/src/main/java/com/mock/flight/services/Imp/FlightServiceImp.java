package com.mock.flight.services.Imp;

import com.mock.flight.exception.MockProjectException;
import com.mock.flight.model.Flight;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface FlightServiceImp {

    List<Flight> findAllFlights();

    void createFlights(Flight flight) throws MockProjectException;

    void updateFlight(Flight airPlane, Long id) throws MockProjectException;

    void deleteFlight(Long id) throws MockProjectException;

    void saveFlight(Flight flight);

    Optional<Flight> findIdFlight(Long id);
}
