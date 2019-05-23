package com.biotrio.backend.repository;



import com.biotrio.backend.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface MovieRepo extends CrudRepository<Movie, Integer> {

}