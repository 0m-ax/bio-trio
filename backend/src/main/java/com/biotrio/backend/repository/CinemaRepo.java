package com.biotrio.backend.repository;


import com.biotrio.backend.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface CinemaRepo extends JpaRepository<Cinema, Integer> {

}