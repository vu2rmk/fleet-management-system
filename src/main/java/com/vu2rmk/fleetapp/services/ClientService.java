package com.vu2rmk.fleetapp.services;

import com.vu2rmk.fleetapp.models.Client;
import com.vu2rmk.fleetapp.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public void save(Client client){
        clientRepository.save(client);
    }

    public Client findById(Integer id){
        return clientRepository.findById(id).get();
    }

    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }
}
