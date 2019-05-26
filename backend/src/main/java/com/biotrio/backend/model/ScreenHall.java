package com.biotrio.backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "screenHalls")
public class ScreenHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int screenHallID;

    private String name;

    @ManyToOne
    @JoinColumn(
            name = "cinemaID"
    )
    private Cinema cinema;

    @OneToMany(mappedBy = "screenHall")
    private List<Seat> seats;

    public ScreenHall(){

    }

    public ScreenHall(String name) {
        this.name = name;
    }

    public int getScreenHallID() {
        return screenHallID;
    }

    public void setScreenHallID(int screenHallID) {
        this.screenHallID = screenHallID;
    }


    @Override
    public String toString(){
        return "screenHalls{}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
}
