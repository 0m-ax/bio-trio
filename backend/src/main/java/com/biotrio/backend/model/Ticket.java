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
            name = "screeningID",
            foreignKey = @ForeignKey(name = "FKtickets768009", value = ConstraintMode.NO_CONSTRAINT)
    )
    private Screening screening;

    @ManyToOne
    @JoinColumn(
            name = "seatID",
            foreignKey = @ForeignKey(name = "FKorders391475", value = ConstraintMode.NO_CONSTRAINT)
    )
    private Seat seat;

    @ManyToOne
    @JoinColumn(
            name = "OrderNumber",
            foreignKey = @ForeignKey(name = "FKtickets650174", value = ConstraintMode.NO_CONSTRAINT)
    )
    private Order order;



    public Ticket(){

    }

    public Ticket(String ticketNumber, String ticketStatus, int screeningID, int orderNumber, int seatID) {
        this.ticketNumber = ticketNumber;
        this.ticketStatus = ticketStatus;
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
}

