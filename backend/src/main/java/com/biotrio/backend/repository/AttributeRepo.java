package com.biotrio.backend.repository;


import com.biotrio.backend.model.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepo extends JpaRepository<Attribute, Integer> {

}