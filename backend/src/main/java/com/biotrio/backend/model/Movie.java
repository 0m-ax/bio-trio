package com.biotrio.backend.model;


import org.springframework.data.rest.core.config.Projection;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Movie")


public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieID;

    private String name;
    private int length;
    @Lob
    private String description;
    private String ageRating;
    private String genre;
    private String image;
    private String video;
    @Column(name = "rentingStart", columnDefinition="DATETIME")
    private Date rentingStart;

    @Column(name = "rentingEnd", columnDefinition="DATETIME")
    private Date rentingEnd;

    @OneToMany(mappedBy = "movie")
    private List<Screening> screenings;
    public Movie(){
    }

    public Movie(String name, int length, String description, String ageRating, String genre,Date rentingStart, Date rentingEnd ) {
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
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

    public List<Screening> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<Screening> screenings) {
        this.screenings = screenings;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
