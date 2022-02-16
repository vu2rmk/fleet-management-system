package com.vu2rmk.fleetapp.services;

import com.vu2rmk.fleetapp.models.Vehicle;
import com.vu2rmk.fleetapp.models.Supplier;
import com.vu2rmk.fleetapp.models.Vehicle;
import com.vu2rmk.fleetapp.repositories.VehicleRepository;
import com.vu2rmk.fleetapp.repositories.SupplierRepository;
import com.vu2rmk.fleetapp.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles(){
        return vehicleRepository.findAll();
    }

    public void save(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }

    public Vehicle findById(Integer id){
        return vehicleRepository.findById(id).get();
    }

    public void delete(Integer id) {
        vehicleRepository.deleteById(id);
    }
}
