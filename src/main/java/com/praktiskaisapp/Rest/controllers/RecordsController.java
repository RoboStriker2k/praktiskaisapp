package com.praktiskaisapp.Rest.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.praktiskaisapp.Rest.Entity.records;
import com.praktiskaisapp.Rest.Service.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class RecordsController {
    @Autowired
    private RecordsService recordsService;

    @GetMapping("Finderecordbyid")
    public records findById(long id) {
        return recordsService.findById(id);
    }

    public void deleteById(long id) {
        recordsService.deleteById(id);
    }

    public boolean existsById(long id) {
        return recordsService.existsById(id);
    }

    public Iterable<records> findAll() {
        return recordsService.findAll();
    }

    public records save(records records) {
        return recordsService.save(records);
    }

    public String updateRecords(long id, records records) {
        return recordsService.updateRecords(id, records);
    }

}
