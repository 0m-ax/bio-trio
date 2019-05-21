package com.biotrio.backend.model;


import javax.persistence.*;

@Entity
@Table(name="seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatID;

    private String x;
    private String y;
    private String seatName;

    public Seat(){
    }

    public Seat(String x, String y, String seatName) {
        this.x = x;
        this.y = y;
        this.seatName = seatName;
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    @Override
    public String toString(){
        return "seats{}";
    }
}
