package com.vhbeltramini.dronezeta.repository;

import com.vhbeltramini.dronezeta.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer>{

    Optional<Order> findByUserIdAndStatus(Integer id, Order.OrderStatus orderStatus);

}
