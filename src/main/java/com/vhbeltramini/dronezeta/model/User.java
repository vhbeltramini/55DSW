package com.vhbeltramini.dronezeta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Size;

@Entity
public abstract class User {
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=5, message="O primeiro nome deve ter pelo menos 3 caracteres")
	private String firstName;

	@Size(min=3, message="O ultimo nome deve ter pelo menos 3 caracteres")
	private String lastName;

	@Size(min=11, message="O cpf deve ter pelo menos 11 caracteres")
	private Integer cpf;

	@Size(min=3, message="O email deve ter pelo menos 3 caracteres")
	private String email;

	@OneToOne
	private Address address;

	public User() {}

	public User(String firstName, String lastName, Integer cpf, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpf = cpf;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String nome) {
		this.firstName = nome;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
