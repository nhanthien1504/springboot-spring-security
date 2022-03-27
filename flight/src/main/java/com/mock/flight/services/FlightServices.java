package com.mock.flight.services;

import com.mock.flight.exception.MockProjectException;
import com.mock.flight.model.Flight;
import com.mock.flight.repository.FlightRepository;
import com.mock.flight.services.Imp.FlightServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FlightServices implements FlightServiceImp {

    @Autowired
    private FlightRepository flightRepository;


    @Override
    public List<Flight> findAllFlights() {
       return flightRepository.findAll();
    }


    @Override
    public void createFlights(Flight flight) throws MockProjectException {
        validateFlight(flight);
        Flight fromDB = new Flight();
        fromDB.setId(flight.getId());
        fromDB.setFlightCode(fromDB.getFlightCode());
        fromDB.setDepartStation(flight.getDepartStation());
        fromDB.setArriveAtStation(flight.getArriveAtStation());
        fromDB.setDepartureTime(flight.getDepartureTime());
        fromDB.setEndTime(flight.getEndTime());
        fromDB.setFlyingRange(flight.getFlyingRange());
        fromDB.setPrice(flight.getPrice());
        flightRepository.save(flight);
    }

    @Override
    public void updateFlight(Flight flight, Long id) throws MockProjectException {
        validateFlight(flight);
        Optional<Flight> idFlight = flightRepository.findById(id);
        if (idFlight.isPresent()) {
            Flight fromDB = new Flight();
            fromDB.setDepartStation(flight.getDepartStation());
            fromDB.setArriveAtStation(flight.getArriveAtStation());
            fromDB.setDepartureTime(flight.getDepartureTime());
            fromDB.setEndTime(flight.getEndTime());
            fromDB.setFlyingRange(flight.getFlyingRange());
            flightRepository.saveAndFlush(flight);
        }
    }

    @Override
    public void deleteFlight(Long id) throws MockProjectException {
        Optional<Flight> idFlight = flightRepository.findById(id);
        if (idFlight.isPresent()) {
            flightRepository.deleteById(id);
        } else {
            throw new MockProjectException("You can not delete Flight with this id");
        }
    }

    @Override
    public void saveFlight(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public Optional<Flight> findIdFlight(Long id) {
        return flightRepository.findById(id);

    }

    private void validateFlight(Flight flight) throws MockProjectException {
        if (flight.getFlightCode() == null) {
            throw new MockProjectException("You can not get FlightCode null");
        }
        if (flight.getFlyingRange() == 0) {
            throw new MockProjectException("You can not get Flight equal 0");
        }
        if (flight.getArriveAtStation() == null || flight.getDepartStation() == null) {
            throw new MockProjectException("You can not get Arrive at station or get Depart station equal null");
        }
        if (flight.getDepartureTime() == null || flight.getEndTime() == null) {
            throw new MockProjectException("You can not get Depart Time or get End time equal null");
        } else
            throw new MockProjectException();
    }


}
