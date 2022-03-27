package com.mock.flight.services;

import com.mock.flight.exception.MockProjectException;
import com.mock.flight.model.AirPlane;
import com.mock.flight.repository.AirPlaneRepository;
import com.mock.flight.services.Imp.AirPlanesServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirPlaneServices implements AirPlanesServiceImp {

    @Autowired
    private AirPlaneRepository airPlaneRepository;

    private void validateAirPlane(AirPlane airPlane) throws MockProjectException {
        if (airPlane.getAirCraftType() == null) {
            throw new MockProjectException("You can not get AircraftType null");
        }
    }

    @Override
    public List<AirPlane> getAllAirPlanes() {
        return airPlaneRepository.findAll();
    }

    @Override
    public void createAirPlane(AirPlane airPlane) throws MockProjectException {
        validateAirPlane(airPlane);
        AirPlane fromDB = new AirPlane();
        fromDB.setAirCraftType(airPlane.getAirCraftType());
        fromDB.setAirPlaneCode(airPlane.getAirPlaneCode());
        fromDB.setFlyingRange(airPlane.getFlyingRange());
        fromDB.setId(airPlane.getId());
        airPlaneRepository.save(airPlane);
    }

    @Override
    public void updateAirPlane(AirPlane airPlane, Long id) throws MockProjectException {
        validateAirPlane(airPlane);
        Optional<AirPlane> idAirPlaneUpdate = airPlaneRepository.findById(id);
        if (idAirPlaneUpdate.isPresent()) {
            AirPlane fromDB = idAirPlaneUpdate.get();
            fromDB.setAirPlaneCode(airPlane.getAirPlaneCode());
            fromDB.setAirCraftType(airPlane.getAirCraftType());
            fromDB.setFlyingRange(airPlane.getFlyingRange());
            airPlaneRepository.saveAndFlush(fromDB);
        } else {
            System.out.println("can not update airplane");
        }
    }

    @Override
    public void deleteAirPlane(Long id) {
        Optional<AirPlane> idAirPlaneDelete = airPlaneRepository.findById(id);
        if (idAirPlaneDelete.isPresent()) {
            airPlaneRepository.deleteById(id);
        } else {
            System.out.println("find not id");
        }
    }

    @Override
    public List<AirPlane> getFlyingRange(int range) {
        return null;
    }


    @Override
    public List<AirPlane> getAirCraftTypeAndAirPlaneCode(String airCraftType, String airPlaneCode) {
        return airPlaneRepository.findByAirCraftTypeAndAirPlaneCode(airCraftType, airPlaneCode);
    }

//    @Override
//    public List<AirPlane> getFlyingRange(int range) {
//        return airPlaneRepository.findByFlyingRange(range);
//    }


}
