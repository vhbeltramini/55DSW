package com.vhbeltramini.dronezeta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;


@Entity
public class PaymentMethod {
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=5, message="O nome deve ter pelo menos 3 caracteres")
	private Integer cardNumber;

	@Size(min=11, message="O cpf deve ter pelo menos 11 caracteres")
	private String validDate;


	public PaymentMethod() {}

	public PaymentMethod(Integer cardNumber, String validDate) {
		super();
		this.cardNumber = cardNumber;
		this.validDate = validDate;
	}
}
