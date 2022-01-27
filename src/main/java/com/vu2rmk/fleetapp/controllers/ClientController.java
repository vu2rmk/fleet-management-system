package com.vu2rmk.fleetapp.controllers;

import com.vu2rmk.fleetapp.models.Country;
import com.vu2rmk.fleetapp.models.Client;
import com.vu2rmk.fleetapp.models.State;
import com.vu2rmk.fleetapp.services.CountryService;
import com.vu2rmk.fleetapp.services.ClientService;
import com.vu2rmk.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private StateService stateService;

    @GetMapping("/clients")
    public String getClients(Model model){

        List<Client> clientList = clientService.getClients();
        model.addAttribute("clients",clientList);

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries",countryList);

        List<State> stateList = stateService.getStates();
        model.addAttribute("states",stateList);
        return "client";
    }

    @PostMapping("/clients/addNew")
    public String addNew(Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping("clients/findById")
    @ResponseBody
    public Client findById(Integer id){
        return clientService.findById(id);
    }

    @RequestMapping(value = "/clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/clients/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        clientService.delete(id);
        return "redirect:/clients";
    }
}
