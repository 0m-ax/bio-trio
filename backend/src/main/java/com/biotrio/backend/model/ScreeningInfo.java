package com.biotrio.backend.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;

/**
 * Represents a projection of the Screening class
 * This is done to gather exactly the necessary data for an action
 */
@Projection(
        name = "ScreeningInfo",
        types = { Screening.class })
public interface ScreeningInfo {
    int getScreeningID();
    Timestamp getStartTime();
    int getCleaning();
    Movie getMovie();
    ScreenHall getScreenHall();
    int getCost();
}