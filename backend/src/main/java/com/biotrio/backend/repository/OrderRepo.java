package com.biotrio.backend.repository;



import com.biotrio.backend.model.Order;
import com.biotrio.backend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends CrudRepository<Order, Integer> {
    List<Order> findByCustomer(User user);
}