package com.vhbeltramini.dronezeta.model;

import jakarta.persistence.Entity;


@Entity
public class Admin extends User {

	public Admin() {}

	public Admin(String nome, Integer cpf, String email) {
		super(nome, cpf, email);
	}

}
