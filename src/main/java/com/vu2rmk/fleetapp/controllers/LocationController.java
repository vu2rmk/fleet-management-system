package com.vu2rmk.fleetapp.controllers;

import com.vu2rmk.fleetapp.models.Country;
import com.vu2rmk.fleetapp.models.Location;
import com.vu2rmk.fleetapp.models.State;
import com.vu2rmk.fleetapp.services.CountryService;
import com.vu2rmk.fleetapp.services.LocationService;
import com.vu2rmk.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LocationController {


    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private LocationService locationService;

    @GetMapping("/locations")
    public String getLocations(Model model){

        List<State> stateList = stateService.getStates();
        model.addAttribute("states",stateList);

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries",countryList);

        List<Location> locationList = locationService.getLocations();
        model.addAttribute("locations", locationList);
        return "location";
    }

    @PostMapping("/locations/addNew")
    public String addNew(Location location) {
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping("locations/findById")
    @ResponseBody
    public Location findById(Integer id){
        return locationService.findById(id);
    }

    @RequestMapping(value = "/locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Location location) {
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/locations/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        locationService.delete(id);
        return "redirect:/locations";
    }
}
