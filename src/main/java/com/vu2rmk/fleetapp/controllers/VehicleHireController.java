package com.vu2rmk.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleHireController {

    @GetMapping("/vehiclehires")
    public String getVehicleHires(){
        return "VehicleHire";
    }
}
