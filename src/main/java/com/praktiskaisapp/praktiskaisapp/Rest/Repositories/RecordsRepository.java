package com.praktiskaisapp.praktiskaisapp.Rest.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.praktiskaisapp.praktiskaisapp.Rest.Entity.records;

@RepositoryRestResource(collectionResourceRel = "records", path = "records")
public interface RecordsRepository extends CrudRepository<records, Long> {         
    public records findById(long id);
    public void deleteById(long id);
    public boolean existsById(long id);
    @SuppressWarnings("null")
    public Iterable<records> findAll();
    @SuppressWarnings({ "null", "unchecked" })
    public records save(records records);
}
