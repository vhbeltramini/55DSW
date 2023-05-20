package com.vhbeltramini.dronezeta.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;


@Entity
public class ProductStorage {
	@Id
	@GeneratedValue
	private Integer id;

	private Integer quantity;

	private String size;


	public ProductStorage() {}

	public ProductStorage(Integer id, Integer quantity, String size) {
		this.id = id;
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
