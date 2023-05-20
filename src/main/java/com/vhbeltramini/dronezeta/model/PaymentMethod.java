package com.vhbeltramini.dronezeta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;


@Entity
public class PaymentMethod {
	@Id
	@GeneratedValue
	private Integer id;

	private String cardNumber;

	private String validDate;

	private String cardHolderName;

	@Size(max=3)
	private String cvv;


	public PaymentMethod() {}

	public PaymentMethod(String cardNumber, String validDate, String cardHolderName, String cvv) {
		super();
		this.cardNumber = cardNumber;
		this.validDate = validDate;
		this.cvv = cvv;
		this.cardHolderName = cardHolderName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
}
