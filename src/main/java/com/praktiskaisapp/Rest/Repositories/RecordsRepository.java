package com.praktiskaisapp.Rest.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.praktiskaisapp.Rest.Entity.records;

@Repository
public interface RecordsRepository extends CrudRepository<records, Long> {         
    
}
