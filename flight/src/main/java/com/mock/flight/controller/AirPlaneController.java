package com.mock.flight.controller;

import com.mock.flight.exception.MockProjectException;
import com.mock.flight.model.AirPlane;
import com.mock.flight.services.AirPlaneServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airplane")
public class AirPlaneController {

    @Autowired
    private AirPlaneServices airPlaneServices;

    @GetMapping("/find")
    public List<AirPlane> getAllAirPlane() {
        return airPlaneServices.getAllAirPlanes();
    }

//    @GetMapping("/find")
//    public List<AirPlane> getConditionRange(@RequestParam("range") int Range) {
//        return airPlaneServices.getFlyingRange(Range);
//    }

    @GetMapping("/findcondition/{airPlaneCode}")
    public List<AirPlane> getConditionAirCraftTypeAndAirCode(@PathVariable("airPlaneCode")String airPlaneCode,
                                                             @RequestParam("airCraftType") String airCraftType) {
        return airPlaneServices.getAirCraftTypeAndAirPlaneCode(airCraftType, airPlaneCode);
    }

    @PostMapping("/create")
    public void createAirplane(@RequestBody AirPlane airPlane) throws MockProjectException {
        airPlaneServices.createAirPlane(airPlane);
    }

    @DeleteMapping("/delete")
    public void deleteAirplane(@RequestParam("id") Long idAirplane) {
        airPlaneServices.deleteAirPlane(idAirplane);
    }

    @PutMapping("/update")
    public void updateAirplane(@RequestBody AirPlane airPlane, @RequestParam("id") Long id) throws MockProjectException {
        airPlaneServices.updateAirPlane(airPlane, id);
    }
}
