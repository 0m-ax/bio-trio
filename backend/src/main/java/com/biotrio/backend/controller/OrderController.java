package com.biotrio.backend.controller;

import com.biotrio.backend.PayPalClient;
import com.biotrio.backend.model.Order;
import com.biotrio.backend.repository.OrderRepo;
import com.biotrio.backend.repository.OrderStatusRepo;
import com.braintreepayments.http.serializer.Json;
import com.paypal.orders.OrdersGetRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.http.HttpResponse;
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
    ResponseEntity<?> getProducers(@PathVariable(value="orderID") int id,@RequestParam String paypalOrderID) {
        Optional<Order> orderO = orderRepo.findById(id);
        if(!orderO.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Order order = orderO.get();
        OrdersGetRequest request = new OrdersGetRequest(paypalOrderID);
        //3. Call PayPal to get the transaction
        try {
            com.braintreepayments.http.HttpResponse<com.paypal.orders.Order> response = new PayPalClient().client().execute(request);
            //4. Save the transaction in your database. Implement logic to save transaction to your database for future reference.
            System.out.println("Full response body:");
            System.out.println(new JSONObject(new Json().serialize(response.result())).toString(4));
        }catch (IOException e){
            System.out.println(e);
            return ResponseEntity.badRequest().build();

        }

        order.setOrderStatus(orderStatusRepo.findById(2).get());
        orderRepo.save(order);
        return ResponseEntity.ok(true);
    }
}
