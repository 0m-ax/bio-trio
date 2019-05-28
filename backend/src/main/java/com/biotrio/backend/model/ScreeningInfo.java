package com.biotrio.backend.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;

@Projection(
        name = "ScreeningInfo",
        types = { Screening.class })
public interface ScreeningInfo {
    int getScreeningID();
    Timestamp getStartTime();
    int getCleaning();
    Movie getMovie();
    ScreenHall getScreenHall();
}