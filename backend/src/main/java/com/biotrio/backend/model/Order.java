package com.biotrio.backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderNumber;
    @ManyToOne
    @JoinColumn(
            name = "orderStatusID"
    )
    private OrderStatus orderStatus;


    @ManyToOne
    @JoinColumn(
            name = "customerID"
    )
    private User customer;

    @OneToMany(mappedBy = "order")
    private List<Ticket> tickets;

    public Order() {
    }

    public Order(OrderStatus orderStatus, User customer) {
        this.orderStatus = orderStatus;
        this.customer = customer;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "orders{}";
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
