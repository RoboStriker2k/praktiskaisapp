package com.praktiskaisapp.Rest.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.praktiskaisapp.Rest.Entity.computer;

@Repository
public interface ComputerRepository extends CrudRepository<computer, Long> {
        public computer findById(long id);

        public void deleteById(long id);

        public boolean existsById(long id);

        public boolean existsByCpu(String Cpu);

        public boolean existsByRamAmmount(Integer RamAmmount);

        public boolean existsByGpu(String Gpu);

        public boolean existsByMotherboard(String Motherboard);

        public boolean existsByStorage_ammount(Integer Storage_ammount);

        public boolean existsByComments(String Comments);

        public boolean existsByOperating_system(String Operating_system);

        public List<computer> findByCpu(String Cpu);

        public List<computer> findByRamAmmount(Integer RamAmmount);

        public List<computer> findByGpu(String Gpu);

        public List<computer> findByMotherboard(String Motherboard);

        public List<computer> findByStorage_ammount(Integer Storage_ammount);

        public List<computer> findByOperating_system(String Operating_system);

        @SuppressWarnings("null")
        public Iterable<computer> findAll() ;

        @SuppressWarnings({ "null", "unchecked" })
        public computer save(computer computer);

        public String updateComputer(long id, computer computer);
}
