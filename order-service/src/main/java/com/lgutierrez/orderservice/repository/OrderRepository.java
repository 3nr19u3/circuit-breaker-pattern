package com.lgutierrez.orderservice.repository;

import com.lgutierrez.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findByOrderNumber(String orderNumber);
}
