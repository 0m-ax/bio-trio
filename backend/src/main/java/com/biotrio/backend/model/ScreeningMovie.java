package com.biotrio.backend.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;

/**
 * Represents a projection of the Screening class
 * This is done to gather exactly the necessary data for the homepage
 */
@Projection(
        name = "ScreeningMovie",
        types = { Screening.class })
public interface ScreeningMovie {
    Timestamp getStartTime();
    int getScreeningID();
    @Value("#{target.getScreenHall().getCinema()}")
    Cinema getCinema();

    Movie getMovie();

}