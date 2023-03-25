package com.vhbeltramini.dronezeta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;


@Entity
public class Product {
	@Id
	@GeneratedValue
	private Integer id;

	@Size(min=3, message="O nome deve ter pelo menos 3 caracteres")
	private String name;

	private Double weight;

	private Double price;

	private String photoUrl;


	public Product() {}

	public Product(Integer id, String name, Double weight, Double price) {
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.price = price;
	}

}
