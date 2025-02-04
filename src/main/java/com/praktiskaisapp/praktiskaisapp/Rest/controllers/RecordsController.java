package com.praktiskaisapp.praktiskaisapp.Rest.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.praktiskaisapp.praktiskaisapp.Rest.Entity.records;
import com.praktiskaisapp.praktiskaisapp.Rest.Service.RecordsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/records")
public class RecordsController {
    @Autowired
    private RecordsService recordsService;

    @GetMapping("/Findbyid")
    public records findById(long id) {
        return recordsService.findById(id);
    }
    @GetMapping("/deletebyid")
    public void deleteById(long id) {
        recordsService.deleteById(id);
    }

    @GetMapping("/recordexistsbyid")
    public boolean existsById(long id) {
        return recordsService.existsById(id);
    }

    @GetMapping("/getallrecords")
    public Iterable<records> findAll() {
        return recordsService.findAll();
    }

    @PostMapping("/newrecord")
    public records save(records records) {
        return recordsService.save(records);
    }

    @PutMapping("/updaterecord/{id}")
    public String updateRecords(@PathVariable long id, @RequestBody records records) {
        return recordsService.updateRecords(id, records);
    }

}
