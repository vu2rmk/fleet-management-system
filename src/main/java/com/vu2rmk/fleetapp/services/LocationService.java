package com.vu2rmk.fleetapp.services;

import com.vu2rmk.fleetapp.models.Location;
import com.vu2rmk.fleetapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getLocations(){
        return locationRepository.findAll();
    }

    public void save(Location location){
        locationRepository.save(location);
    }

    public Location findById(Integer id){
        return locationRepository.findById(id).get();
    }

    public void delete(Integer id) {
        locationRepository.deleteById(id);
    }
}
