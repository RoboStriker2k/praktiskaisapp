package com.praktiskaisapp.praktiskaisapp.Rest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praktiskaisapp.praktiskaisapp.Rest.Entity.computer;
import com.praktiskaisapp.praktiskaisapp.Rest.Repositories.ComputerRepository;

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
    public boolean existsByRamammount(Integer ramammount) {
        return computerRepository.existsByRamammount(ramammount);
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
    public boolean existsByStorageammount(Integer Storageammount) {
        return computerRepository.existsByStorageammount(Storageammount);
    }

    @Transactional
    public boolean existsByComments(String Comments) {
        return computerRepository.existsByComments(Comments);
    }

    @Transactional
    public boolean existsByOperatingsystem(String Operatingsystem) {
        return computerRepository.existsByOperatingsystem(Operatingsystem);
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
    public List<computer> findByRamAmmount(Integer ramammount) {
        return computerRepository.findByRamammount(ramammount);
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

    public List<computer> findByStorageammount(Integer Storageammount) {
        return computerRepository.findByStorageammount(Storageammount);
    }

    @Transactional
    public List<computer> findByOperatingsystem(String Operatingsystem) {
        return computerRepository.findByOperatingsystem(Operatingsystem);
    }

    @Transactional
    public Iterable<computer> findAll() {
        return computerRepository.findAll();
    }

    @Transactional
    public void save(computer computer) {
        try {
        computerRepository.save(computer);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
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
    public String updateComputer(long id, computer updatedComputer) {
        try {
            computer existingComputer = computerRepository.findById(id);
            if (existingComputer != null) {
                existingComputer.setCpu(updatedComputer.getCpu());
                existingComputer.setRamAmmount(updatedComputer.getRamAmmount());
                existingComputer.setGpu(updatedComputer.getGpu());
                existingComputer.setMotherboard(updatedComputer.getMotherboard());
                existingComputer.setStorageammount(updatedComputer.getStorageammount());
                existingComputer.setComments(updatedComputer.getComments());
                existingComputer.setOperatingsystem(updatedComputer.getOperatingsystem());
                computerRepository.save(existingComputer);
                return "Computer successfully edited";
            } else {
                return "Computer not found";
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
    }
