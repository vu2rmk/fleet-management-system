package com.vu2rmk.fleetapp.services;

import com.vu2rmk.fleetapp.models.Supplier;
import com.vu2rmk.fleetapp.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getSuppliers(){
        return supplierRepository.findAll();
    }

    public void save(Supplier supplier){
        supplierRepository.save(supplier);
    }

    public Supplier findById(Integer id){
        return supplierRepository.findById(id).get();
    }

    public void delete(Integer id) {
        supplierRepository.deleteById(id);
    }
}
