package com.vhbeltramini.dronezeta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;


@Entity
public class Address {
	@Id
	@GeneratedValue
	private Integer id;

	@Size(min=3, message="A cidade deve ter pelo menos 3 caracteres")
	private String city;

	private String street;

	@Size(min=3, message="O bairro deve ter pelo menos 3 caracteres")
	private String province;

	private String zipCode;

	private String country;


	public Address() {}

	public Address(String city, String street, String province, String zipCode, String country) {
		super();
		this.city = city;
		this.street = street;
		this.province = province;
		this.zipCode = zipCode;
		this.country = country;
	}

}
