package com.vu2rmk.fleetapp.services;

import com.vu2rmk.fleetapp.models.VehicleType;
import com.vu2rmk.fleetapp.repositories.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleTypeService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    public List<VehicleType> getVehicleTypes(){
        return vehicleTypeRepository.findAll();
    }

    public void save(VehicleType vehicleType){
        vehicleTypeRepository.save(vehicleType);
    }

    public VehicleType findById(Integer id){
        return vehicleTypeRepository.findById(id).get();
    }

    public void delete(Integer id) {
        vehicleTypeRepository.deleteById(id);
    }
}
