package com.vu2rmk.fleetapp.services;

import com.vu2rmk.fleetapp.models.Invoice;
import com.vu2rmk.fleetapp.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getInvoices(){
        return invoiceRepository.findAll();
    }

    public void save(Invoice invoice){
        invoiceRepository.save(invoice);
    }

    public Invoice findById(Integer id){
        return invoiceRepository.findById(id).get();
    }

    public void delete(Integer id) {
        invoiceRepository.deleteById(id);
    }
}
