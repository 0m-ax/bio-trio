package com.biotrio.backend.repository;


import com.biotrio.backend.model.Screening;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepo extends CrudRepository<Screening, Integer> {

}