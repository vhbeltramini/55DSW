package com.vhbeltramini.dronezeta.service.rest;

import com.vhbeltramini.dronezeta.model.PaymentMethod;
import com.vhbeltramini.dronezeta.model.User;
import com.vhbeltramini.dronezeta.repository.PaymentMethodRepository;
import com.vhbeltramini.dronezeta.repository.UserRepository;
import com.vhbeltramini.dronezeta.service.dto.PaymentMethodDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class PaymentMethodController {


    private PaymentMethodRepository repository;
    private UserRepository userRepository;

    public PaymentMethodController(PaymentMethodRepository repository, UserRepository userRepository) {
        super();
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @PostMapping("/payment-methods/create")
    public PaymentMethod create(@Valid @RequestBody PaymentMethodDTO paymentMethodDTO){
        PaymentMethod paymentMethod = new PaymentMethod(paymentMethodDTO.getCardNumber().trim(), paymentMethodDTO.getValidDate(), paymentMethodDTO.getCardHolderName(), paymentMethodDTO.getCvv());

        PaymentMethod saved = repository.save(paymentMethod);

        User user = userRepository.findById(paymentMethodDTO.getUser()).orElseThrow();

        user.addPaymentMethodList(paymentMethod);

        userRepository.save(user);
        return saved;
    }



}
