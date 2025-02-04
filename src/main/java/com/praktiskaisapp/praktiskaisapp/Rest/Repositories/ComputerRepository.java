package com.praktiskaisapp.praktiskaisapp.Rest.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.praktiskaisapp.praktiskaisapp.Rest.Entity.computer;

@RepositoryRestResource(collectionResourceRel = "computers", path = "computers")

public interface ComputerRepository extends CrudRepository<computer, Long> {
        public computer findById(long id);

        public void deleteById(long id);

        public boolean existsById(long id);

        public boolean existsByCpu(String cpu);

        public boolean existsByRamammount(Integer ramammount);

        public boolean existsByGpu(String gpu);

        public boolean existsByMotherboard(String motherboard);

        public boolean existsByStorageammount(Integer storageammount);

        public boolean existsByComments(String comments);

        public boolean existsByOperatingsystem(String operatingsystem);

        public List<computer> findByCpu(String cpu);

        public List<computer> findByRamammount(Integer ramammount);

        public List<computer> findByGpu(String gpu);

        public List<computer> findByMotherboard(String motherboard);

        public List<computer> findByStorageammount(Integer storageammount);

        public List<computer> findByOperatingsystem(String operatingsystem);

        @SuppressWarnings("null")
        public Iterable<computer> findAll() ;

        @SuppressWarnings({ "null", "unchecked" })
        public computer save(computer computer);
}
