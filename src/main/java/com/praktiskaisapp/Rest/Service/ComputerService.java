package com.praktiskaisapp.Rest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praktiskaisapp.Rest.Entity.computer;
import com.praktiskaisapp.Rest.Repositories.ComputerRepository;

import jakarta.transaction.Transactional;
@Service
public class ComputerService {
    @Autowired
    private ComputerRepository computerRepository;

    @Transactional
    public void deleteById(long id) {
        computerRepository.deleteById(id);
    }

    @Transactional
    public boolean existsById(long id) {
        return computerRepository.existsById(id);
    }

    @Transactional
    public boolean existsByCpu(String Cpu) {
        return computerRepository.existsByCpu(Cpu);
    }

    @Transactional
    public boolean existsByRamAmmount(Integer RamAmmount) {
        return computerRepository.existsByRamAmmount(RamAmmount);
    }

    @Transactional
    public boolean existsByGpu(String Gpu) {
        return computerRepository.existsByGpu(Gpu);
    }

    @Transactional
    public boolean existsByMotherboard(String Motherboard) {
        return computerRepository.existsByMotherboard(Motherboard);
    }

    @Transactional
    public boolean existsByStorage_ammount(Integer Storage_ammount) {
        return computerRepository.existsByStorage_ammount(Storage_ammount);
    }

    @Transactional
    public boolean existsByComments(String Comments) {
        return computerRepository.existsByComments(Comments);
    }

    @Transactional
    public boolean existsByOperating_system(String Operating_system) {
        return computerRepository.existsByOperating_system(Operating_system);
    }

    @Transactional
    public computer findById(long id) {
        return computerRepository.findById(id);
    }

    @Transactional
    public List<computer> findByCpu(String Cpu) {
        return computerRepository.findByCpu(Cpu);
    }

    @Transactional
    public List<computer> findByRamAmmount(Integer RamAmmount) {
        return computerRepository.findByRamAmmount(RamAmmount);
    }

    @Transactional
    public List<computer> findByGpu(String Gpu) {
        return computerRepository.findByGpu(Gpu);
    }

    @Transactional
    public List<computer> findByMotherboard(String Motherboard) {
        return computerRepository.findByMotherboard(Motherboard);
    }

    @Transactional

    public List<computer> findByStorage_ammount(Integer Storage_ammount) {
        return computerRepository.findByStorage_ammount(Storage_ammount);
    }

    @Transactional
    public List<computer> findByOperating_system(String Operating_system) {
        return computerRepository.findByOperating_system(Operating_system);
    }

    @Transactional
    public Iterable<computer> findAll() {
        return computerRepository.findAll();
    }

    @Transactional
    public void save(computer computer) {
        computerRepository.save(computer);
    }

    @Transactional
    public void deleteAll() {
        computerRepository.deleteAll();
    }

    @Transactional
    public void delete(computer computer) {
        computerRepository.delete(computer);
    }
    @Transactional
    public String updateComputer (long id, computer computer) {
      try {
        
        return "Computer successfully edited";
      } catch (Exception e) {
        return "Error: " + e.getMessage();
      }
    }
    }
