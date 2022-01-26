package com.vu2rmk.fleetapp.controllers;

import com.vu2rmk.fleetapp.models.EmployeeType;
import com.vu2rmk.fleetapp.services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeTypeController {

    @Autowired
    private EmployeeTypeService employeeTypeService;

    @GetMapping("/employeeTypes")
    public String getEmployeeTypes(Model model){

        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
        model.addAttribute("employeeTypes", employeeTypeList);
        return "employeeType";
    }

    @PostMapping("/employeeTypes/addNew")
    public String addNew(EmployeeType employeeType) {
        employeeTypeService.save(employeeType);
        return "redirect:/employeeTypes";
    }

    @RequestMapping("employeeTypes/findById")
    @ResponseBody
    public EmployeeType findById(Integer id){
        return employeeTypeService.findById(id);
    }

    @RequestMapping(value = "/employeeTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(EmployeeType employeeType) {
        employeeTypeService.save(employeeType);
        return "redirect:/employeeTypes";
    }

    @RequestMapping(value = "/employeeTypes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        employeeTypeService.delete(id);
        return "redirect:/employeeTypes";
    }
}
