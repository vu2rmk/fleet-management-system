package com.vu2rmk.fleetapp.services;

import com.vu2rmk.fleetapp.models.Contact;
import com.vu2rmk.fleetapp.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }

    public void save(Contact contact){
        contactRepository.save(contact);
    }

    public Contact findById(Integer id){
        return contactRepository.findById(id).get();
    }

    public void delete(Integer id) {
        contactRepository.deleteById(id);
    }
}
