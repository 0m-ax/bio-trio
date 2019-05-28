package com.biotrio.backend.model;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "screenings")
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int screeningID;

    @Column(name = "startTime", columnDefinition="DATETIME")
    private Timestamp startTime;

    private int cleaning;

    @ManyToOne
    @JoinColumn(
            name = "movieID"
    )
    private Movie movie;

    @ManyToOne()
    @JoinColumn(
            name = "projectionistEmployeID"
    )
    private User projectionist;
    @OneToMany(mappedBy = "screening")
    private List<Ticket> tickets;
    @ManyToOne
    @JoinColumn(
            name = "screenHallID"
    )
    private ScreenHall screenHall;
    private int cost;
    public Screening(){
    }

    public Screening(Timestamp startTime, int cleaning, int cost) {
        this.startTime = startTime;
        this.cleaning = cleaning;
        this.cost = cost;
    }

    public int getScreeningID() {
        return screeningID;
    }

    public void setScreeningID(int screeningID) {
        this.screeningID = screeningID;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }


    @Override
    public String toString(){
        return "screenings{}";
    }

    public int getCleaning() {
        return cleaning;
    }

    public void setCleaning(int cleaning) {
        this.cleaning = cleaning;
    }

    public ScreenHall getScreenHall() {
        return screenHall;
    }

    public void setScreenHall(ScreenHall screenHall) {
        this.screenHall = screenHall;
    }


    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getProjectionist() {
        return projectionist;
    }

    public void setProjectionist(User projectionist) {
        this.projectionist = projectionist;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
