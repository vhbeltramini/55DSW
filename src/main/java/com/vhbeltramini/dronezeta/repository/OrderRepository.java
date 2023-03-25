package com.vhbeltramini.dronezeta.repository;

import com.vhbeltramini.dronezeta.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
