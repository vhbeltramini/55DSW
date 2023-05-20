package com.vhbeltramini.dronezeta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Size;

import java.util.List;


@Entity
public class Product {
	@Id
	@GeneratedValue
	private Integer id;

	@Size(min=3, message="O nome deve ter pelo menos 3 caracteres")
	private String name;

	private Double price;

	@ManyToMany
	private List<ProductStorage> productStorages;

	private String photoUrl;


	public Product() {}

	public Product(Integer id, String name, Double price, List<ProductStorage> productStorages, String photoUrl) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.productStorages = productStorages;
		this.photoUrl = photoUrl;
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

	public List<ProductStorage> getProductStorages() {
		return productStorages;
	}

	public void setProductStorages(List<ProductStorage> productStorages) {
		this.productStorages = productStorages;
	}

}
