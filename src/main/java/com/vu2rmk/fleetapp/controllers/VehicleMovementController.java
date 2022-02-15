package com.vu2rmk.fleetapp.controllers;

import com.vu2rmk.fleetapp.models.Location;
import com.vu2rmk.fleetapp.models.Supplier;
import com.vu2rmk.fleetapp.models.Vehicle;
import com.vu2rmk.fleetapp.models.VehicleMovement;
import com.vu2rmk.fleetapp.services.LocationService;
import com.vu2rmk.fleetapp.services.SupplierService;
import com.vu2rmk.fleetapp.services.VehicleMovementService;
import com.vu2rmk.fleetapp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VehicleMovementController {

    @Autowired
    private VehicleMovementService vehicleMovementService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private LocationService locationService;

    @GetMapping("/vehicleMovements")
    public String getVehicleMovements(Model model){

        List<VehicleMovement> vehicleMovementList = vehicleMovementService.getVehicleMovements();
        model.addAttribute("vehicleMovements",vehicleMovementList);

        List<Vehicle> vehicleList = vehicleService.getVehicles();
        model.addAttribute("vehicles",vehicleList);

        List<Location> locationList = locationService.getLocations();
        model.addAttribute("locations",locationList);
        return "vehicleMovement";
    }

    @PostMapping("/vehicleMovements/addNew")
    public String addNew(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovements";
    }

    @RequestMapping("vehicleMovements/findById")
    @ResponseBody
    public VehicleMovement findById(Integer id){
        return vehicleMovementService.findById(id);
    }

    @RequestMapping(value = "/vehicleMovements/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovements";
    }

    @RequestMapping(value = "/vehicleMovements/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMovementService.delete(id);
        return "redirect:/vehicleMovements";
    }
}
