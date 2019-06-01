package com.biotrio.backend.model;

import javax.persistence.*;

/**
 * Represents the order_status table in the database
 *
 * This class contains methods related to setting and getting different parameters of an order status.
 * Spring automatically generates the attribute table in the localhost using this model
 */
@Entity
@Table(name = "orderStatus")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderStatusID;
    private boolean seatTaken;
    private boolean usable;
    private String name;
    public int getOrderStatusID() {
        return orderStatusID;
    }

    public void setOrderStatusID(int orderStatusID) {
        this.orderStatusID = orderStatusID;
    }

    public boolean getSeatTaken() {
        return seatTaken;
    }

    public void setSeatTaken(boolean seatTaken) {
        this.seatTaken = seatTaken;
    }

    public boolean getUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
