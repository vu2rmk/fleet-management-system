
package com.vu2rmk.fleetapp.services;

import com.vu2rmk.fleetapp.models.VehicleMovement;
import com.vu2rmk.fleetapp.repositories.VehicleMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleMovementService {

    @Autowired
    private VehicleMovementRepository vehicleMovementRepository;

    public List<VehicleMovement> getVehicleMovements(){
        return vehicleMovementRepository.findAll();
    }

    public void save(VehicleMovement vehicleMovement){
        vehicleMovementRepository.save(vehicleMovement);
    }

    public VehicleMovement findById(Integer id){
        return vehicleMovementRepository.findById(id).get();
    }

    public void delete(Integer id) {
        vehicleMovementRepository.deleteById(id);
    }
}
