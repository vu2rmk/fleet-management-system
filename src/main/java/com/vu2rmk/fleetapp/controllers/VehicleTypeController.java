package com.vu2rmk.fleetapp.controllers;

import com.vu2rmk.fleetapp.models.VehicleType;
import com.vu2rmk.fleetapp.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping("/vehicleTypes")
    public String getVehicleTypes(Model model){

        List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypes();
        model.addAttribute("vehicleTypes", vehicleTypeList);
        return "vehicleType";
    }

    @PostMapping("/vehicleTypes/addNew")
    public String addNew(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleTypes";
    }

    @RequestMapping("vehicleTypes/findById")
    @ResponseBody
    public VehicleType findById(Integer id){
        return vehicleTypeService.findById(id);
    }

    @RequestMapping(value = "/vehicleTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleTypes";
    }

    @RequestMapping(value = "/vehicleTypes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleTypeService.delete(id);
        return "redirect:/vehicleTypes";
    }
}
