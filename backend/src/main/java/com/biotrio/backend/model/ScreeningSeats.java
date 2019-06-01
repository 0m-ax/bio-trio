package com.biotrio.backend.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;
import java.util.List;

/**
 * Represents a projection of the Screening class
 * This is done to gather exactly the necessary data for an action
 */
@Projection(
        name = "ScreeningSeats",
        types = { Screening.class })
public interface ScreeningSeats {

    @Value("#{target.getScreenHall().getSeats()}")
    List<Seat> getSeats();
    Movie getMovie();
    Timestamp getStartTime();
    int getCost();
}