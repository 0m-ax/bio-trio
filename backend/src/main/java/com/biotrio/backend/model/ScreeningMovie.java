package com.biotrio.backend.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;

@Projection(
        name = "ScreeningMovie",
        types = { Screening.class })
public interface ScreeningMovie {
    Timestamp getStartTime();

    @Value("#{target.getScreenHall().getCinema()}")
    Cinema getCinema();

    Movie getMovie();

}