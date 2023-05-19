package com.vhbeltramini.dronezeta.model;

import com.vhbeltramini.dronezeta.model.enums.TravelStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;


@Entity
public class Travel {
	@Id
	@GeneratedValue
	private Integer id;

	@OneToMany
	private List<Product> products;

	private TravelStatus status;

	private String timeToDelivery;

	public Travel() {}

	public Travel(List<Product> products, TravelStatus status) {
		super();
		this.products = products;
		this.status = status;
		this.timeToDelivery = LocalDateTime.now().plusMinutes(2).toString();
	}

	public boolean isDelivered() {
		return this.status.isDelivered();
	}



}
