package com.vu2rmk.fleetapp.controllers;

import com.vu2rmk.fleetapp.models.Client;
import com.vu2rmk.fleetapp.models.Country;
import com.vu2rmk.fleetapp.models.Invoice;
import com.vu2rmk.fleetapp.models.InvoiceStatus;
import com.vu2rmk.fleetapp.services.ClientService;
import com.vu2rmk.fleetapp.services.CountryService;
import com.vu2rmk.fleetapp.services.InvoiceService;
import com.vu2rmk.fleetapp.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/invoices")
    public String getCountries(Model model){

        List<Invoice> invoiceList = invoiceService.getInvoices();
        model.addAttribute("invoices",invoiceList);

        List<Client> clientList = clientService.getClients();
        model.addAttribute("clients",clientList);

        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuses();
        model.addAttribute("invoiceStatuses",invoiceStatusList);
        return "invoice";
    }

    @PostMapping("/invoices/addNew")
    public String addNew(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping("invoices/findById")
    @ResponseBody
    public Invoice findById(Integer id){
        return invoiceService.findById(id);
    }

    @RequestMapping(value = "/invoices/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping(value = "/invoices/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        invoiceService.delete(id);
        return "redirect:/invoices";
    }
}
