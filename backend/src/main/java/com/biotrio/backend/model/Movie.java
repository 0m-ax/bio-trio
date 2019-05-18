package com.biotrio.backend.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieID;

    private String name;
    private String length;
    private String description;
    private String ageRating;
    private String genre;

    @Column(name = "rentingStart", columnDefinition="DATETIME")
    private Date rentingStart;

    @Column(name = "rentingEnd", columnDefinition="DATETIME")
    private Date rentingEnd;

    public Movie(){
    }

    public Movie(String name, String length, String description, String ageRating, String genre,Date rentingStart, Date rentingEnd ) {
        this.name = name;
        this.length = length;
        this.description = description;
        this.ageRating = ageRating;
        this.genre = genre;
        this.rentingStart = rentingStart;
        this.rentingEnd = rentingEnd;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getRentingStart() {
        return rentingStart;
    }

    public void setRentingStart(Date rentingStart) {
        this.rentingStart = rentingStart;
    }

    public Date getRentingEnd() {
        return rentingEnd;
    }

    public void setRentingEnd(Date rentingEnd) {
        this.rentingEnd = rentingEnd;
    }

    @Override
    public String toString() {
        return "movies{}";
    }

}
