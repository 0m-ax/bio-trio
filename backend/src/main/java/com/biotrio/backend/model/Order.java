package com.biotrio.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderNumber;

    private String orderStatus;


    @ManyToOne
    @JoinColumn(
            name = "customerID",
            foreignKey = @ForeignKey(name = "FKorders391475", value = ConstraintMode.NO_CONSTRAINT)
    )
    private User customer;



    public Order() {
    }

    public Order(String orderStatus, int customerID) {
        this.orderStatus = orderStatus;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "orders{}";
    }
}
