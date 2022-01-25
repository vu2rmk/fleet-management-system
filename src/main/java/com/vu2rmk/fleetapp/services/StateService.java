
package com.vu2rmk.fleetapp.services;

import com.vu2rmk.fleetapp.models.State;
import com.vu2rmk.fleetapp.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> getStates(){
        return stateRepository.findAll();
    }

    public void save(State state){
        stateRepository.save(state);
    }

    public State findById(Integer id){
        return stateRepository.findById(id).get();
    }

    public void delete(Integer id) {
        stateRepository.deleteById(id);
    }
}
