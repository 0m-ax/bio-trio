package com.biotrio.backend.repository;


import com.biotrio.backend.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@RepositoryRestResource
public interface ScreeningRepo extends JpaRepository<Screening, Integer> {
    @Query("select s from  Screening s JOIN s.screenHall h JOIN h.cinema c WHERE c.cinemaID = ?1")
    List<Screening> getByCinemaID(Integer chinemaID);
    @Query("select s from Screening  s where YEAR(?1) = YEAR(s.startTime) AND MONTH(?1) = MONTH(s.startTime) AND DAY(?1)+1= (DAY(s.startTime))")
    public List<Screening> findByStartTime(Date startTime);

}