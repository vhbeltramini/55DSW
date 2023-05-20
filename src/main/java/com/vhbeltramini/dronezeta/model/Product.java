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

	private Double height;

	private Double price;

	private Integer quantity;

	private String photoUrl;


	public Product() {}

	public Product(Integer id, String name, Double weight, Double height, Double price, Integer quantity) {
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.height = height;
		this.price = price;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}
}
