package com.vhbeltramini.dronezeta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
public class ProductStorage {
	@Id
	@GeneratedValue
	private Integer id;

	@OneToOne
	private Product name;

	private Integer quantity;

	private String size;


	public ProductStorage() {}

	public ProductStorage(Product name, Integer quantity, String size) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.size = size;
	}
}
