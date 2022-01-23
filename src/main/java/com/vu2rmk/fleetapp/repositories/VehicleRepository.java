package com.vu2rmk.fleetapp.repositories;

import com.vu2rmk.fleetapp.models.Client;
import com.vu2rmk.fleetapp.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
