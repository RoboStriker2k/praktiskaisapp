package com.praktiskaisapp.Rest.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.praktiskaisapp.Rest.Entity.records;

@Repository
public interface RecordsRepository extends CrudRepository<records, Long> {         
        public records findById(long id);
        public void deleteById(long id);
        public boolean existsById(long id);
        public Iterable<records>  findAll();
        public records save(records records);
       public String updateRecords(long id, records records);
    
}
