package com.mock.flight.controller;

import com.mock.flight.exception.MockProjectException;
import com.mock.flight.model.Flight;
import com.mock.flight.services.FlightServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController{

    @Autowired
    FlightServices flightServices;


    @GetMapping("/find")
    public List<Flight> getFlightAll() {
        return flightServices.findAllFlights();
    }


    @PutMapping("/update")
    public void updateFlight(@RequestBody Flight flight, @RequestParam("id") Long idFlight) throws MockProjectException {
        flightServices.updateFlight(flight, idFlight);
    }

    @PostMapping("/create")
    public void createFlight(@RequestBody Flight flight) throws MockProjectException {
         flightServices.createFlights(flight);
    }

    @DeleteMapping("/delete")
    public void deleteFlight(@RequestParam("id") Long idFlight) throws MockProjectException {
        flightServices.deleteFlight(idFlight);
    }



}
