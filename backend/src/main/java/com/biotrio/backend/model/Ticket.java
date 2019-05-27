package com.biotrio.backend.model;


import javax.persistence.*;

@Entity
@Table(name ="tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketID;

    private String ticketNumber;
    private String ticketStatus;

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



    public Ticket(){

    }

    public Ticket(Screening screening,Seat seat,Order order) {
        this.order = order;
        this.screening = screening;
        this.seat = seat;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
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
}

