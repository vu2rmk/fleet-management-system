
package com.vu2rmk.fleetapp.services;

import com.vu2rmk.fleetapp.models.VehicleHire;
import com.vu2rmk.fleetapp.repositories.VehicleHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleHireService {

    @Autowired
    private VehicleHireRepository vehicleHireRepository;

    public List<VehicleHire> getVehicleHires(){
        return vehicleHireRepository.findAll();
    }

    public void save(VehicleHire vehicleHire){
        vehicleHireRepository.save(vehicleHire);
    }

    public VehicleHire findById(Integer id){
        return vehicleHireRepository.findById(id).get();
    }

    public void delete(Integer id) {
        vehicleHireRepository.deleteById(id);
    }
}
