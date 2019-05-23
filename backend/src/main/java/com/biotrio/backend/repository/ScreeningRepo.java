package com.biotrio.backend.repository;


import com.biotrio.backend.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface ScreeningRepo extends JpaRepository<Screening, Integer> {
    @Query("select s from  Screening s JOIN s.screenHall h JOIN h.cinema c WHERE c.cinemaID = ?1")
    List<Screening> getByCinemaID(Integer chinemaID);
}