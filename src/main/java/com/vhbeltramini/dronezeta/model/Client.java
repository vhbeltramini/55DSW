package com.vhbeltramini.dronezeta.model;

import com.vhbeltramini.dronezeta.model.enums.Roles;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.security.NoSuchAlgorithmException;
import java.util.List;


@Entity
public class Client extends User {

	@OneToMany(mappedBy="user")
	private List<PaymentMethod> paymentMethods;

	@OneToOne
	private Address deliveryAddress;

	public Client() {}

	public Client(String firstName, String lastName, Integer cpf, String email, Roles role, String password) throws NoSuchAlgorithmException {
		super(firstName, lastName, cpf, email, Roles.CLIENT, password);
	}

	public List<PaymentMethod> getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
}
