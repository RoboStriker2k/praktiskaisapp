package com.praktiskaisapp.Rest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.praktiskaisapp.Rest.Entity.records;
import com.praktiskaisapp.Rest.Repositories.RecordsRepository;

@Service
public class RecordsService {
    @Autowired
    private RecordsRepository recordsRepository;
    
    @Transactional
    public void deleteById(long id) {
        recordsRepository.deleteById(id);
    }

    @Transactional
    public boolean existsById(long id) {
        return recordsRepository.existsById(id);
    }
    
    @Transactional
    public  records findById(long id) {
        return recordsRepository.findById(id);
    }
    
    @Transactional
    public void save(records records) {
        recordsRepository.save(records);
    }
    @Transactional
    public Iterable<records> findAll() {
        return recordsRepository.findAll();
    }
    @Transactional
    public String updateRecords (long id, records records) {
      try {
        recordsRepository.updateRecords(id,records);
        return "Records successfully edited";
      } catch (Exception e) {
        return "Error: " + e.getMessage();
      }
    }

}
