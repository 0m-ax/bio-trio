package com.biotrio.backend.repository;


import com.biotrio.backend.model.Screening;
import com.biotrio.backend.model.Seat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepo extends CrudRepository<Seat, Integer> {
    @Query("select se from  Screening s JOIN s.tickets t JOIN t.order o join o.orderStatus os join t.seat se where os.seatTaken = 1 and s.screeningID = ?1")
    List<Seat> getByAvalibleForScreeningID(Integer screeningID);
}