package com.vhbeltramini.dronezeta.model;

import com.vhbeltramini.dronezeta.model.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private String email;

	private String address;

	private String deliveryAddress;

	private String passwordHash;

	@Transient
	private String password;

	@OneToMany
	private List<PaymentMethod> paymentMethodList;

	@Enumerated(EnumType.STRING)
	private Role role;

	public User() {}

	public User(String firstName, String lastName, String cpf, String email, String password) throws NoSuchAlgorithmException {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public List<PaymentMethod> getPaymentMethodList() {
		return paymentMethodList;
	}

	public void setPaymentMethodList(List<PaymentMethod> paymentMethodList) {
		this.paymentMethodList = paymentMethodList;
	}

	public void addPaymentMethodList(PaymentMethod paymentMethod) {
		this.paymentMethodList.add(paymentMethod);
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

