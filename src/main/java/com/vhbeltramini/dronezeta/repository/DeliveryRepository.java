package com.vhbeltramini.dronezeta.repository;

import com.vhbeltramini.dronezeta.model.Delivery;
import com.vhbeltramini.dronezeta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{

    Optional<Delivery> findByOrderId(Integer id);

}
