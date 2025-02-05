package com.praktiskaisapp.praktiskaisapp.Rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.praktiskaisapp.praktiskaisapp.Rest.Entity.computer;

import com.praktiskaisapp.praktiskaisapp.Rest.Service.ComputerService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/computer")
public class ComputerController {
    @Autowired
    private ComputerService computerService;

    @GetMapping("/info")
    public String computerinfo() {
        return "Computer system working";
    }

    @DeleteMapping("/deletecomputer/{id}")
    public void deletecomputer(@PathVariable long id) {
        computerService.deleteById(id);
    }

    @GetMapping("/computerexistsbyid")
    public boolean existsbyid(@RequestParam long id) {
        return computerService.existsById(id);
    }

    @GetMapping("/computerexistsbycpu")
    public boolean existsbycpu(@RequestParam String Cpu) {
        return computerService.existsByCpu(Cpu);
    }

    @GetMapping("/computerexistsbyramammount")
    public boolean existsbyRamammount(@RequestParam Integer ramammount) {
        return computerService.existsByRamammount(ramammount);
    }

    @PostMapping("/newcomputer")
    public String newcomputer(@RequestBody  String computer) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            
            computer computera = mapper.readValue(computer, computer.class);
            computerService.save(computera);
            return "Computer successfully added";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/getcomputer")
    public String getComputer(@RequestParam long id) {
        try {
            return computerService.findById(id).toString();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @PutMapping("/updateComputer/{id}")
    public String edit(@PathVariable long id, @RequestBody computer computer) {
        try {
            computerService.updateComputer(id, computer);
            return "Computer successfully edited";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/getallcomputers")
    public Iterable<computer> findAll() {
        return computerService.findAll();
    }
}
