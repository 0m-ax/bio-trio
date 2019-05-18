package com.biotrio.backend.model;


import javax.persistence.*;

@Entity
@Table(name = "screenings")
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int screeningID;

    private String startTime;
    private String seatCapacityX;
    private String seatCapacityY;

    public Screening(){
    }

    public Screening(String startTime, String seatCapacityX, String seatCapacityY) {
        this.startTime = startTime;
        this.seatCapacityX = seatCapacityX;
        this.seatCapacityY = seatCapacityY;
    }

    public int getScreeningID() {
        return screeningID;
    }

    public void setScreeningID(int screeningID) {
        this.screeningID = screeningID;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getSeatCapacityX() {
        return seatCapacityX;
    }

    public void setSeatCapacityX(String seatCapacityX) {
        this.seatCapacityX = seatCapacityX;
    }

    public String getSeatCapacityY() {
        return seatCapacityY;
    }

    public void setSeatCapacityY(String seatCapacityY) {
        this.seatCapacityY = seatCapacityY;
    }

    @Override
    public String toString(){
        return "screenings{}";
    }
}
