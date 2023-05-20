package com.vhbeltramini.dronezeta.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;


@Entity
public class ProductStorage {
	@Id
	@GeneratedValue
	private Integer id;

	private Integer quantity;

	private Double weight;

	private Double height;

	private String size;


	public ProductStorage() {}

	public ProductStorage(Double weight, Double height, Integer quantity, String size, Product product) {
		super();
		this.weight = weight;
		this.height = height;
		this.quantity = quantity;
		this.size = size;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
