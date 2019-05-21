package com.biotrio.backend.repository;


import com.biotrio.backend.model.Cinema;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface CinemaRepo extends CrudRepository<Cinema, Integer> {

}