package com.vu2rmk.fleetapp.controllers;

import com.vu2rmk.fleetapp.models.Supplier;
import com.vu2rmk.fleetapp.models.Vehicle;
import com.vu2rmk.fleetapp.models.VehicleMaintenance;
import com.vu2rmk.fleetapp.models.Country;
import com.vu2rmk.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VehicleMaintenanceController {

    @Autowired
    private VehicleMaintenanceService vehicleMaintenanceService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/vehicleMaintenances")
    public String getVehicleMaintenances(Model model){

        List<VehicleMaintenance> vehicleMaintenanceList = vehicleMaintenanceService.getVehicleMaintenances();
        model.addAttribute("vehicleMaintenances",vehicleMaintenanceList);

        List<Vehicle> vehicleList = vehicleService.getVehicles();
        model.addAttribute("vehicles",vehicleList);

        List<Supplier> supplierList = supplierService.getSuppliers();
        model.addAttribute("suppliers",supplierList);
        return "vehicleMaintenance";
    }

    @PostMapping("/vehicleMaintenances/addNew")
    public String addNew(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenances";
    }

    @RequestMapping("vehicleMaintenances/findById")
    @ResponseBody
    public VehicleMaintenance findById(Integer id){
        return vehicleMaintenanceService.findById(id);
    }

    @RequestMapping(value = "/vehicleMaintenances/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenances";
    }

    @RequestMapping(value = "/vehicleMaintenances/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMaintenanceService.delete(id);
        return "redirect:/vehicleMaintenances";
    }
}
