package com.biotrio.backend.model;


import javax.persistence.*;

/**
 * Represents the ticket table in the database
 *
 * This class contains methods related to setting and getting different parameters of tickets.
 * Spring automatically generates the ticket table in the localhost using this model
 */
@Entity
@Table(name ="tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketID;

    private boolean used;

    @ManyToOne
    @JoinColumn(
            name = "screeningID"
    )
    private Screening screening;

    @ManyToOne
    @JoinColumn(
            name = "seatID"
    )
    private Seat seat;

    @ManyToOne
    @JoinColumn(
            name = "OrderNumber"
    )
    private Order order;

    private int cost;

    public Ticket(){

    }

    public Ticket(Screening screening,Seat seat,Order order,int cost) {
        this.order = order;
        this.screening = screening;
        this.seat = seat;
        this.cost = cost;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }


    @Override
    public String toString(){
        return "tickets{}";
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public boolean getUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}

