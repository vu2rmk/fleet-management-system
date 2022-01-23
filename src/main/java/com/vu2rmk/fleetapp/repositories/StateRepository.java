package com.vu2rmk.fleetapp.repositories;

import com.vu2rmk.fleetapp.models.Client;
import com.vu2rmk.fleetapp.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
}
