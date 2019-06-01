package com.biotrio.backend.model;


import javax.persistence.*;

/**
 * Represents the cinema table in the database
 *
 * This class contains methods related to setting and getting different parameters of a cinema.
 * Spring automatically generates the cinema table in the localhost using this model
 */
@Entity
@Table(name = "cinemas")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cinemaID;

    private String address;
    private String description;
    private String name;
    public Cinema(){

    }

    public Cinema(String address, String description,String name) {
        this.address = address;
        this.description = description;
        this.name = name;
    }

    public int getCinemaID() {
        return cinemaID;
    }

    public void setCinemaID(int cinemaID) {
        this.cinemaID = cinemaID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "cinemas{}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
