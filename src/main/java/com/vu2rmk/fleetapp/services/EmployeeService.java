package com.vu2rmk.fleetapp.services;

import com.vu2rmk.fleetapp.models.Employee;
import com.vu2rmk.fleetapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public void save(Employee employee){
        employeeRepository.save(employee);
    }

    public Employee findById(Integer id){
        return employeeRepository.findById(id).get();
    }

    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }
}
