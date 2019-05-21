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
}
