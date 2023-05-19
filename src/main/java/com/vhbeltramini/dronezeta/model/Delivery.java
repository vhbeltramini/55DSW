package com.vhbeltramini.dronezeta.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Delivery {
	@Id
	@GeneratedValue
	private Integer id;

	@OneToOne
	private Address address;

	@OneToOne
	private Order order;

	@OneToMany
	private List<Travel> travels;

	public Delivery() {}

	public Delivery(Address address, Order order, List<Travel> travels) {
		super();
		this.address = address;
		this.order = order;
		this.travels = travels;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Travel> getTravels() {
		return travels;
	}

	public void setTravels(List<Travel> travels) {
		this.travels = travels;
	}

	public void addTravel(Travel travel) {
		this.travels.add(travel);
	}
}
