package com.biotrio.backend.repository;


import com.biotrio.backend.model.ScreenHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenHallRepo extends JpaRepository<ScreenHall, Integer> {

}
