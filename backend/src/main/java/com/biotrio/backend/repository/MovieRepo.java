package com.biotrio.backend.repository;



import com.biotrio.backend.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends CrudRepository<Movie, Integer> {

}