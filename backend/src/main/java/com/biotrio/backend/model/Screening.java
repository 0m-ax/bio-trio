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

    private int interval;

    @ManyToOne
    @JoinColumn(
            name = "movieID",
            foreignKey = @ForeignKey(name = "FKscreenings386176", value = ConstraintMode.NO_CONSTRAINT)
    )
    private Movie movie;

    @ManyToOne
    @JoinColumn(
            name = "employeeID",
            foreignKey = @ForeignKey(name = "FKscreenings822069", value = ConstraintMode.NO_CONSTRAINT)
    )
    private Employee employee;

    @ManyToOne
    @JoinColumn(
            name = "screenHallID",
            foreignKey = @ForeignKey(name = "FKscreenings347078", value = ConstraintMode.NO_CONSTRAINT)
    )
    private ScreenHall screenHall;



    public Screening(){
    }

    public Screening(Date startTime, int interval) {
        this.startTime = startTime;
        this.interval = interval;
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

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    @Override
    public String toString(){
        return "screenings{}";
    }
}
