package com.vu2rmk.fleetapp.controllers;

import com.vu2rmk.fleetapp.models.VehicleStatus;
import com.vu2rmk.fleetapp.services.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VehicleStatusController {
    @Autowired
    private VehicleStatusService vehicleStatusService;

    @GetMapping("/vehiclestatuses")
    public String getVehicleStatuses(Model model){

        List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatuses();
        model.addAttribute("vehicleStatuses", vehicleStatusList);
        return "vehicleStatus";
    }

    @PostMapping("/vehicleStatuses/addNew")
    public String addNew(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatuses";
    }

    @RequestMapping("vehicleStatuses/findById")
    @ResponseBody
    public VehicleStatus findById(Integer id){
        return vehicleStatusService.findById(id);
    }

    @RequestMapping(value = "/vehicleStatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatuses";
    }

    @RequestMapping(value = "/vehicleStatuses/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleStatusService.delete(id);
        return "redirect:/vehicleStatuses";
    }

}
