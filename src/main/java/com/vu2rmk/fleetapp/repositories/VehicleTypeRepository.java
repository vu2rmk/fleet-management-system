package com.vu2rmk.fleetapp.repositories;


import com.vu2rmk.fleetapp.models.Contact;
import com.vu2rmk.fleetapp.models.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Integer> {
}
