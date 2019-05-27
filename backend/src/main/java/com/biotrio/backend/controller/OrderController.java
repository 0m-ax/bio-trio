package com.biotrio.backend.controller;

import com.biotrio.backend.model.Order;
import com.biotrio.backend.repository.OrderRepo;
import com.biotrio.backend.repository.OrderStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RequestMapping(value = "/api/orders")
@RepositoryRestController
public class OrderController {
    private OrderRepo orderRepo;
    private OrderStatusRepo orderStatusRepo;

    @Autowired
    public OrderController(OrderRepo orderRepo, OrderStatusRepo orderStatusRepo){
        this.orderRepo = orderRepo;
        this.orderStatusRepo = orderStatusRepo;
    }
    @RequestMapping(method = GET, value = "/{orderID}/pay")
    public @ResponseBody
    ResponseEntity<?> getProducers(@PathVariable(value="orderID") int id) {
        Optional<Order> orderO = orderRepo.findById(id);
        if(!orderO.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Order order = orderO.get();
        order.setOrderStatus(orderStatusRepo.findById(2).get());
        orderRepo.save(order);
        return ResponseEntity.ok(true);
    }
}
