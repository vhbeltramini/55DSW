package com.vhbeltramini.dronezeta.model;

import jakarta.persistence.Entity;


@Entity
public class Admin extends User {

	public Admin() {}

	public Admin(String firstName, String lastName, Integer cpf, String email) {
		super(firstName, lastName, cpf, email);
	}

}
