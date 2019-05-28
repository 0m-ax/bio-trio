package com.biotrio.backend.repository;


import com.biotrio.backend.model.Screening;
import com.biotrio.backend.model.Seat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepo extends CrudRepository<Seat, Integer> {
    @Query("select se from  Screening s JOIN s.screenHall h JOIN h.seats se JOIN se.tickets t JOIN t.order o JOIN o.orderStatus os WHERE s.screeningID = ?1 AND os.seatTaken = TRUE")
    List<Seat> getByAvalibleForScreeningID(Integer screeningID);
}