package com.biotrio.backend.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;

/**
 * Represents a projection of the Ticket class
 * This is done to gather exactly the necessary data for an action
 */
@Projection(
        name = "TicketInfo",
        types = { Ticket.class })
public interface TicketInfo {
    int getTicketID();
    @Value("#{target.getScreening()}")
    Screening getScreening();
    @Value("#{target.getScreening().getMovie()}")
    Movie getMovie();
    @Value("#{target.getSeat()}")
    Seat getSeat();
    @Value("#{target.getUsed()}")
    boolean getUsed();
}