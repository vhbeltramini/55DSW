package com.vhbeltramini.dronezeta.service.rest;

import com.vhbeltramini.dronezeta.model.Order;
import com.vhbeltramini.dronezeta.model.Product;
import com.vhbeltramini.dronezeta.model.User;
import com.vhbeltramini.dronezeta.model.enums.OrderStatus;
import com.vhbeltramini.dronezeta.repository.OrderRepository;
import com.vhbeltramini.dronezeta.repository.UserRepository;
import com.vhbeltramini.dronezeta.service.dto.OrderDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class OrderController {
    private OrderRepository repository;
    private UserRepository userRepository;

    public OrderController(OrderRepository repository, UserRepository userRepository) {
        super();
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> create(@Valid @RequestBody Order order){
//        User user = userRepository.findById(orderDTO.getUser()).orElseThrow();
        order.setStatus(OrderStatus.READY);
//        Order newOrder = new Order(orderDTO.getProducts(), orderDTO.getDate(), user, orderDTO.getPaymentMethod(), OrderStatus.READY);
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
    public Order getOderByUserIDAndStatus(@PathVariable(value = "user_id") Integer user_id) throws Exception {
        return repository.findByUserIdAndStatus(user_id, OrderStatus.READY)
                .orElseThrow(() -> new Exception("Order not found for this user id :: " + user_id));
    }

    @GetMapping(path= "/orders/user/{user_id}")
    public List<Order> getOderByUserID(@PathVariable(value = "user_id") Integer user_id) throws Exception {
        return repository.findByUserId(user_id)
                .orElseThrow(() -> new Exception("Order not found for this user id :: " + user_id));
    }

    @PostMapping(path= "/orders/sent/{id}")
    public Order sentOrder(@PathVariable(value = "id") Integer id) throws Exception {
        Order order = repository.findById(id)
                .orElseThrow(() -> new Exception("Order not found for this id :: " + id));

        order.setStatus(OrderStatus.SENT);

        repository.save(order);

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
