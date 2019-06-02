package com.biotrio.backend.model;


import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * Represents the movie table in the database
 *
 * This class contains methods related to setting and getting different parameters of movies.
 * Spring automatically generates the movie table in the localhost using this model
 */
@Entity
@Table(name = "Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieID;
    @Length(min=1)
    private String name;
    @Min(1)
    private int length;
    @Lob
    @Length(min=1)
    private String description;
    @Length(min=1)
    private String ageRating;
    @Length(min=1)
    private String genre;
    @Length(min=1)
    private String image;
    @Length(min=1)
    private String video;

    @OneToMany(mappedBy = "movie")
    private List<Screening> screenings;
    public Movie(){
    }

    public Movie(String name, int length, String description, String ageRating, String genre) {
        this.name = name;
        this.length = length;
        this.description = description;
        this.ageRating = ageRating;
        this.genre = genre;
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
