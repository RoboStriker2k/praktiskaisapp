package com.praktiskaisapp.praktiskaisapp.Rest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.praktiskaisapp.praktiskaisapp.Rest.Entity.records;
import com.praktiskaisapp.praktiskaisapp.Rest.Repositories.RecordsRepository;

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
        try {
        recordsRepository.save(records);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
    @Transactional
    public Iterable<records> findAll() {
        return recordsRepository.findAll();
    }
    @Transactional
    public String updatestatus (long id, String status) {
        records record = recordsRepository.findById(id);
        if (record != null) {
            record.setStatus(status);
            recordsRepository.save(record);
            return "Status updated successfully";
        } else {
            return "Record not found";
        }
    }
    @Transactional
    public String updateRecords (long id, records newRecord) {
      try {
        records existingRecord = recordsRepository.findById(id);
        if (existingRecord != null) {
            existingRecord.setRequestdate(newRecord.getRequestdate());
            existingRecord.setRequestedevices(newRecord.getRequestedevices());
            existingRecord.setReason(newRecord.getReason());
            existingRecord.setStatus(newRecord.getStatus());
            recordsRepository.save(existingRecord);
            return "Records successfully edited";
        } else {
            return "Record not found";
        }
      } catch (Exception e) {
        return "Error: " + e.getMessage();
      }
    }

}
