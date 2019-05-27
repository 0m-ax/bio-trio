package com.biotrio.backend.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;
import java.util.List;

@Projection(
        name = "ScreeningSeats",
        types = { Screening.class })
public interface ScreeningSeats {

    @Value("#{target.getScreenHall().getSeats()}")
    List<Seat> getSeats();
    Movie getMovie();
    Timestamp getStartTime();
}