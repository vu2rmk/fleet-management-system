
package com.vu2rmk.fleetapp.services;

import com.vu2rmk.fleetapp.models.VehicleMaintenance;
import com.vu2rmk.fleetapp.repositories.VehicleMaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleMaintenanceService {

    @Autowired
    private VehicleMaintenanceRepository vehicleMaintenanceRepository;

    public List<VehicleMaintenance> getVehicleMaintenances(){
        return vehicleMaintenanceRepository.findAll();
    }

    public void save(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenanceRepository.save(vehicleMaintenance);
    }

    public VehicleMaintenance findById(Integer id){
        return vehicleMaintenanceRepository.findById(id).get();
    }

    public void delete(Integer id) {
        vehicleMaintenanceRepository.deleteById(id);
    }
}
