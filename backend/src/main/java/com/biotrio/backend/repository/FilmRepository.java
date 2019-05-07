package com.biotrio.backend.repository;

import com.biotrio.backend.model.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> {

}