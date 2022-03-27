package com.mock.flight.services.Imp;

import com.mock.flight.model.Staff;

import java.util.List;

public interface StaffServiceImp {
    List<Staff> getAllAirPlanes();

    void createStaff(Staff staff);

    void updateStaff(Staff staff);

    void deleteStaff(Long id);
}
