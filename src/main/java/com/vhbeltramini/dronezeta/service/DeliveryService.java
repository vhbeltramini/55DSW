package com.vhbeltramini.dronezeta.service;

import com.vhbeltramini.dronezeta.model.Delivery;
import com.vhbeltramini.dronezeta.repository.DeliveryRepository;
import com.vhbeltramini.dronezeta.service.controller.DeliveryHandler;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class DeliveryService {


    private DeliveryRepository repository;

    public DeliveryService(DeliveryRepository repository) {
        super();
        this.repository = repository;
    }

    @PostMapping("/deliveries/create")
    public ResponseEntity<Delivery> create(@Valid @RequestBody Delivery delivery){
        Delivery saved = repository.save(delivery);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id)")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path= "/deliveries/{order_id}")
    public Delivery getByOrderID(@PathVariable Integer order_id) throws Exception {
        return repository.findByOrderId(order_id)
                .orElseThrow(() -> new Exception("Delivery not found for this order id :: " + order_id));
    }

    @GetMapping(path= "/deliveries/send/{order_id}")
    public Delivery sendDelivery(@PathVariable Integer order_id) throws Exception {

        Delivery delivery = repository.findByOrderId(order_id)
                .orElseThrow(() -> new Exception("Delivery not found for this order id :: " + order_id));

        DeliveryHandler deliveryHandler = new DeliveryHandler(delivery);

        deliveryHandler.process();


        return repository.findByOrderId(order_id)
                .orElseThrow(() -> new Exception("Delivery not found for this order id :: " + order_id));
    }

}
