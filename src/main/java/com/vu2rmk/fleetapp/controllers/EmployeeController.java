package com.vu2rmk.fleetapp.controllers;

import com.vu2rmk.fleetapp.models.Employee;
import com.vu2rmk.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JobTitleService jobTitleService;

    @Autowired
    private EmployeeTypeService employeeTypeService;

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;



    @GetMapping("/employees")
    public String getEmployees(Model model){

        List<Employee> employeeList = employeeService.getEmployees();
        model.addAttribute("employees",employeeList);
        model.addAttribute("employeeTypes",employeeTypeService.getEmployeeTypes());
        model.addAttribute("states",stateService.getStates());
        model.addAttribute("countries",countryService.getCountries());
        model.addAttribute("jobTitles",jobTitleService.getJobTitles());
        return "employee";
    }

    @PostMapping("/employees/addNew")
    public String addNew(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping("employees/findById")
    @ResponseBody
    public Employee findById(Integer id){
        return employeeService.findById(id);
    }

    @RequestMapping(value = "/employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }
}
