package com.biotrio.backend.model;


import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "screenings")
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int screeningID;

    @Column(name = "startTime", columnDefinition="DATETIME")
    private Date startTime;

    private int cleaning;

    @ManyToOne
    @JoinColumn(
            name = "movieID"
    )
    private Movie movie;

    @ManyToOne()
    @JoinColumn(
            name = "employeeID"
    )
    private Employee employee;

    @ManyToOne
    @JoinColumn(
            name = "screenHallID"
    )
    private ScreenHall screenHall;

    public Screening(){
    }

    public Screening(Date startTime, int cleaning) {
        this.startTime = startTime;
        this.cleaning = cleaning;
    }

    public int getScreeningID() {
        return screeningID;
    }

    public void setScreeningID(int screeningID) {
        this.screeningID = screeningID;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
