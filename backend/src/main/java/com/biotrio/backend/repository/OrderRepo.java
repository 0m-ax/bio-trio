package com.biotrio.backend.repository;



import com.biotrio.backend.model.Order;
import com.biotrio.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
    List<Order> findByCustomer(User user);
}