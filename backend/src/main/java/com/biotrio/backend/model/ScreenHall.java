package com.biotrio.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "screenHalls")
public class ScreenHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int screenHallID;

    private String number;
    private int addLength;
    private int default_interval;

    @ManyToOne
    @JoinColumn(
            name = "cinemaID",
            foreignKey = @ForeignKey(name = "FKscreenHall393155", value = ConstraintMode.NO_CONSTRAINT)
    )
    private Cinema cinema;

    @ManyToOne
    @JoinColumn(
            name = "seatID",
            foreignKey = @ForeignKey(name = "FKscreenHall244684", value = ConstraintMode.NO_CONSTRAINT)
    )
    private Seat ID;

    public ScreenHall(){

    }

    public ScreenHall(String number) {
        this.number = number;
    }

    public int getScreenHallID() {
        return screenHallID;
    }

    public void setScreenHallID(int screenHallID) {
        this.screenHallID = screenHallID;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString(){
        return "screenHalls{}";
    }
}
