
package com.vu2rmk.fleetapp.services;

import com.vu2rmk.fleetapp.models.VehicleStatus;
import com.vu2rmk.fleetapp.repositories.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleStatusService {
    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;

    public List<VehicleStatus> getVehicleStatuses(){
        return vehicleStatusRepository.findAll();
    }

    public void save(VehicleStatus vehicleStatus){
        vehicleStatusRepository.save(vehicleStatus);
    }

    public VehicleStatus findById(Integer id){
        return vehicleStatusRepository.findById(id).get();
    }

    public void delete(Integer id) {
        vehicleStatusRepository.deleteById(id);
    }
}
