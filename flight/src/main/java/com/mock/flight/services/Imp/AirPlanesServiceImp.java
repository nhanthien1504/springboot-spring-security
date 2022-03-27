package com.mock.flight.services.Imp;

import com.mock.flight.exception.MockProjectException;
import com.mock.flight.model.AirPlane;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AirPlanesServiceImp {

    List<AirPlane> getAllAirPlanes();

    void createAirPlane(AirPlane airPlane) throws MockProjectException;

    void updateAirPlane(AirPlane airPlane, Long id) throws MockProjectException;

    void deleteAirPlane(Long id);

    List<AirPlane>getFlyingRange(int range);

    List<AirPlane> getAirCraftTypeAndAirPlaneCode(String airPlaneCode, String airCraftType);
}
