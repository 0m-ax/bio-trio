package com.biotrio.backend.repository;


import com.biotrio.backend.model.Seat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepo extends CrudRepository<Seat, Integer> {

}