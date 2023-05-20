package com.vhbeltramini.dronezeta.model;

import com.vhbeltramini.dronezeta.model.enums.TravelStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
public class Travel {
	@Id
	@GeneratedValue
	private Integer id;

	@OneToMany
	private List<Product> products;

	@Enumerated(EnumType.STRING)
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public TravelStatus getStatus() {
		return status;
	}

	public void setStatus(TravelStatus status) {
		this.status = status;
	}

	public String getTimeToDelivery() {
		return timeToDelivery;
	}

	public void setTimeToDelivery(String timeToDelivery) {
		this.timeToDelivery = timeToDelivery;
	}
}
