package com.biotrio.backend.repository;


import com.biotrio.backend.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.sql.Date;
import java.util.List;

@RepositoryRestResource
public interface ScreeningRepo extends JpaRepository<Screening, Integer> {
    @Query("select s from  Screening s JOIN s.screenHall h JOIN h.cinema c WHERE c.cinemaID = ?1 and CURRENT_DATE < s.startTime")
    List<Screening> getByCinemaID(Integer chinemaID);

    @Query("select s from Screening  s join s.screenHall h WHERE" +
            " YEAR(?1) = YEAR(s.startTime) AND MONTH(?1) = MONTH(s.startTime) AND" +
            " ((DAY(?1)+1) >= DAY(s.startTime) OR (DAY(?1)-1) <= DAY(s.startTime))" +
            " AND h.screenHallID = ?2")
    public List<Screening> findByStartTime(Date startTime,int screenHallID);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Screening save(Screening entity);
}