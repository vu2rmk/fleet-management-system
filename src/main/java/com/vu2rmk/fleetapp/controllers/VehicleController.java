package com.vu2rmk.fleetapp.controllers;

import com.vu2rmk.fleetapp.models.Vehicle;
import com.vu2rmk.fleetapp.models.Country;
import com.vu2rmk.fleetapp.models.State;
import com.vu2rmk.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleStatusService vehicleStatusService;

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @Autowired
    private VehicleModelService vehicleModelService;


    @GetMapping("/vehicles")
    public String getVehicles(Model model){

        List<Vehicle> vehicleList = vehicleService.getVehicles();
        model.addAttribute("vehicles",vehicleList);
        model.addAttribute("employees",employeeService.getEmployees());
        model.addAttribute("vehicleStatuses",vehicleStatusService.getVehicleStatuses());
        model.addAttribute("vehicleModels",vehicleModelService.getVehicleModels());
        model.addAttribute("vehicleTypes",vehicleTypeService.getVehicleTypes());
        model.addAttribute("vehicleMakes",vehicleMakeService.getVehicleMakes());
        model.addAttribute("locations",locationService.getLocations());
        return "vehicle";
    }

    @PostMapping("/vehicles/addNew")
    public String addNew(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping("vehicles/findById")
    @ResponseBody
    public Vehicle findById(Integer id){
        return vehicleService.findById(id);
    }

    @RequestMapping(value = "/vehicles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping(value = "/vehicles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleService.delete(id);
        return "redirect:/vehicles";
    }
}
