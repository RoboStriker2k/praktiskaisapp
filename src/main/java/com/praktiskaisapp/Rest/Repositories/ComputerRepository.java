package com.praktiskaisapp.Rest.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.praktiskaisapp.Rest.Entity.computer;

@Repository
public interface ComputerRepository extends CrudRepository<computer, Long> {         
     
     
}
