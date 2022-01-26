package com.vu2rmk.fleetapp.services;

import com.vu2rmk.fleetapp.models.EmployeeType;
import com.vu2rmk.fleetapp.repositories.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeTypeService {

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    public List<EmployeeType> getEmployeeTypes(){
        return employeeTypeRepository.findAll();
    }

    public void save(EmployeeType employeeType){
        employeeTypeRepository.save(employeeType);
    }

    public EmployeeType findById(Integer id){
        return employeeTypeRepository.findById(id).get();
    }

    public void delete(Integer id) {
        employeeTypeRepository.deleteById(id);
    }
}
