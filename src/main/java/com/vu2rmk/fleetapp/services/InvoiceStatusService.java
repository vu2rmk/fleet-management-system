package com.vu2rmk.fleetapp.services;

import com.vu2rmk.fleetapp.models.InvoiceStatus;
import com.vu2rmk.fleetapp.repositories.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceStatusService {

    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;

    public List<InvoiceStatus> getInvoiceStatuses(){
        return invoiceStatusRepository.findAll();
    }

    public void save(InvoiceStatus invoiceStatus){
        invoiceStatusRepository.save(invoiceStatus);
    }

    public InvoiceStatus findById(Integer id){
        return invoiceStatusRepository.findById(id).get();
    }

    public void delete(Integer id) {
        invoiceStatusRepository.deleteById(id);
    }
}
