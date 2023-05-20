package com.vhbeltramini.dronezeta.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vhbeltramini.dronezeta.model.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Entity
public class User {


	private static final Logger logger = LoggerFactory.getLogger(User.class);

	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=5, message="O primeiro nome deve ter pelo menos 3 caracteres")
	@NotBlank
	private String firstName;

	@Size(min=3, message="O ultimo nome deve ter pelo menos 3 caracteres")
	private String lastName;

	@Size(min=11, message="O cpf deve ter pelo menos 11 caracteres")
	private String cpf;

	@Size(min=3, message="O email deve ter pelo menos 3 caracteres")
	@Email
	private String email;

	@OneToOne
	private Address address;

	@OneToOne
	private Address deliveryAddress;

	private String passwordHash;

	@Transient
	private String password;

	@OneToMany
	private List<PaymentMethod> paymentMethodList;

	private Role role;

	public User() {}

	@JsonCreator
	public User(String firstName, String lastName, String cpf, String email) throws NoSuchAlgorithmException {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpf = cpf;
		this.email = email;
		this.role = Role.CLIENT;
		setPasswordHash(password);
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
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

	public Role getRole() {
		return role;
	}

	private String convertPasswordHash(String password) throws NoSuchAlgorithmException {
		System.out.println(password);
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
		System.out.println("result");
		System.out.println(hexString.toString());

		return hexString.toString();
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String password) throws NoSuchAlgorithmException {
		if (password != null) {
			this.passwordHash = convertPasswordHash(password);
		}
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public List<PaymentMethod> getPaymentMethodList() {
		return paymentMethodList;
	}

	public void setPaymentMethodList(List<PaymentMethod> paymentMethodList) {
		this.paymentMethodList = paymentMethodList;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

