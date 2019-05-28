package com.biotrio.backend.repository;



import com.biotrio.backend.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderStatusRepo extends JpaRepository<OrderStatus, Integer> {
}