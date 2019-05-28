package com.biotrio.backend.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;
import java.util.List;

@Projection(
        name = "OrderTicket",
        types = { Order.class })
public interface OrderTicket {

    int getOrderNumber();

    OrderStatus getOrderStatus();
    @Value("#{target.getTickets()[0].getScreening().getMovie()}")
    Movie getMovie();

    @Value("#{target.getTickets()[0].getScreening()}")
    Screening getScreening();

    @Value("#{target.getTickets()[0].getScreening().getScreenHall().getName()}")
    String getScreeningHallName();

    @Value("#{target.getTickets()}")
    List<Ticket> getTickets();
}