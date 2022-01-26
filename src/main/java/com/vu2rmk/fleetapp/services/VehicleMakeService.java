
package com.vu2rmk.fleetapp.services;

import com.vu2rmk.fleetapp.models.VehicleMake;
import com.vu2rmk.fleetapp.repositories.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleMakeService {

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    public List<VehicleMake> getVehicleMakes(){
        return vehicleMakeRepository.findAll();
    }

    public void save(VehicleMake vehicleMake){
        vehicleMakeRepository.save(vehicleMake);
    }

    public VehicleMake findById(Integer id){
        return vehicleMakeRepository.findById(id).get();
    }

    public void delete(Integer id) {
        vehicleMakeRepository.deleteById(id);
    }
}
