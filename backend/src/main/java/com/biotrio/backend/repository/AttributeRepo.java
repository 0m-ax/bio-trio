package com.biotrio.backend.repository;


import com.biotrio.backend.model.Attribute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepo extends CrudRepository<Attribute, Integer> {

}