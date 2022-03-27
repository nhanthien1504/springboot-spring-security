package com.mock.flight.repository;

import com.mock.flight.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff,Long> {

}
