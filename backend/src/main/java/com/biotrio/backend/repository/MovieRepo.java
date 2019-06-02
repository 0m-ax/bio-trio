package com.biotrio.backend.repository;

import com.biotrio.backend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@RepositoryRestResource
public interface MovieRepo extends JpaRepository<Movie, Integer> {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Movie save(Movie entity);
}