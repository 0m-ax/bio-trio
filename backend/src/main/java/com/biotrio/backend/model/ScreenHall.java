package com.biotrio.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "screenHalls")
public class ScreenHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int screenHallID;

    private String number;

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
