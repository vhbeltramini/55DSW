package com.vhbeltramini.dronezeta.service;

import com.vhbeltramini.dronezeta.model.Order;
import com.vhbeltramini.dronezeta.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderService {
    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        super();
        this.repository = repository;
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> create(@Valid @RequestBody Order order){
        Order savedOrder = repository.save(order);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id)")
                .buildAndExpand(savedOrder.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path= "/orders/{id}")
    public Order get(@PathVariable Long id) throws Exception {
        return repository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new Exception("Order not found for this id :: " + id));
    }

    @GetMapping(path= "/orders/open/{user_id}")
    public Order getOderByUserID(@PathVariable(value = "user_id") Integer user_id) throws Exception {
        return repository.findByUserIdAndStatus(user_id, Order.OrderStatus.READY)
                .orElseThrow(() -> new Exception("Order not found for this user id :: " + user_id));
    }

    @PostMapping(path= "/orders/sent/{id}")
    public Order sentOrder(@PathVariable(value = "id") Integer id) throws Exception {
        return repository.findById(id)
                .orElseThrow(() -> new Exception("Order not found for this id :: " + id));
    }

    @DeleteMapping(path= "/orders/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws Exception {
        Order order = repository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new Exception("Order not found for this id :: " + id));

        repository.delete(order);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Order> updateEmployee(@PathVariable(value = "id") Long id, @Valid @RequestBody Order order) throws Exception {

        order.setId(Math.toIntExact(id));

        final Order updatedOrder = repository.save(order);

        return ResponseEntity.ok(updatedOrder);
    }

}
