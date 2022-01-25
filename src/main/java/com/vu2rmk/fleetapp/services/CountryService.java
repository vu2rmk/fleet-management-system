package com.vu2rmk.fleetapp.services;

import com.vu2rmk.fleetapp.models.Country;
import com.vu2rmk.fleetapp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getCountries(){
        return countryRepository.findAll();
    }

    public void save(Country country){
        countryRepository.save(country);
    }

    public Country findById(Integer id){
        return countryRepository.findById(id).get();
    }

    public void delete(Integer id) {
        countryRepository.deleteById(id);
    }
}
