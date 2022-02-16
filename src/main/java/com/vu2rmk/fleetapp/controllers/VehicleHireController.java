package com.vu2rmk.fleetapp.controllers;

import com.vu2rmk.fleetapp.models.VehicleHire;
import com.vu2rmk.fleetapp.services.ClientService;
import com.vu2rmk.fleetapp.services.LocationService;
import com.vu2rmk.fleetapp.services.VehicleHireService;
import com.vu2rmk.fleetapp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VehicleHireController {

    @Autowired
    private VehicleHireService vehicleHireService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private LocationService locationService;

    @GetMapping("/vehicleHires")
    public String getVehicleHires(Model model){

        List<VehicleHire> vehicleHireList = vehicleHireService.getVehicleHires();
        model.addAttribute("vehicleHires", vehicleHireList);
        model.addAttribute("vehicles", vehicleService.getVehicles());
        model.addAttribute("locations", locationService.getLocations());
        model.addAttribute("clients", clientService.getClients());
        return "vehicleHire";
    }

    @PostMapping("/vehicleHires/addNew")
    public String addNew(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHires";
    }

    @RequestMapping("vehicleHires/findById")
    @ResponseBody
    public VehicleHire findById(Integer id){
        return vehicleHireService.findById(id);
    }

    @RequestMapping(value = "/vehicleHires/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHires";
    }

    @RequestMapping(value = "/vehicleHires/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleHireService.delete(id);
        return "redirect:/vehicleHires";
    }
}
