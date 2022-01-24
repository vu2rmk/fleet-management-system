package com.vu2rmk.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupplierController {

    @GetMapping("/suppliers")
    public String getSuppliers(){
        return "Supplier";
    }
}
