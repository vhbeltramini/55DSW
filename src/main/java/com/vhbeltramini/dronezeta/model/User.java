package com.vhbeltramini.dronezeta.model;

import com.vhbeltramini.dronezeta.model.enums.Roles;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Size;

import javax.management.relation.Role;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

	private String passwordHash;

	private Roles role;

	public User() {}

	public User(String firstName, String lastName, Integer cpf, String email, Roles role, String password) throws NoSuchAlgorithmException {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpf = cpf;
		this.email = email;
		this.role = role;
		this.passwordHash = getPasswordHash(password);
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

	public Roles getRole() {
		return role;
	}

	private String getPasswordHash(String password) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(password.getBytes());
		StringBuilder hexString = new StringBuilder();
		for (byte b : hash) {
			String hex = Integer.toHexString(0xff & b);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public void setRole(Roles role) {
		this.role = role;
	}
}
