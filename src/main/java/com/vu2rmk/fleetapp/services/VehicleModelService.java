
package com.vu2rmk.fleetapp.services;

import com.vu2rmk.fleetapp.models.VehicleModel;
import com.vu2rmk.fleetapp.repositories.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleModelService {

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    public List<VehicleModel> getVehicleModels(){
        return vehicleModelRepository.findAll();
    }

    public void save(VehicleModel vehicleModel){
        vehicleModelRepository.save(vehicleModel);
    }

    public VehicleModel findById(Integer id){
        return vehicleModelRepository.findById(id).get();
    }

    public void delete(Integer id) {
        vehicleModelRepository.deleteById(id);
    }
}
