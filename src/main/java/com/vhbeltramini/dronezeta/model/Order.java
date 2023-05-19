package com.vhbeltramini.dronezeta.model;

import com.vhbeltramini.dronezeta.model.enums.OrderStatus;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
public class Order {
	@Id
	@GeneratedValue
	private Integer id;

	@OneToMany
	private List<Product> products;

	private Date date;

	@OneToOne
	private User user;

	@OneToOne
	private PaymentMethod paymentMethod;

	private OrderStatus status;

	@OneToOne
	private Delivery delivery;

	public Order() {}

	public Order(List<Product> products, Date date, User user, PaymentMethod paymentMethod, OrderStatus status) {
		super();
		this.products = products;
		this.date = date;
		this.user = user;
		this.paymentMethod = paymentMethod;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public void printTimeToDeliver() {
		System.out.println("Time to delivery is " +
				this.getStatus().getTimeToDelivery());
	}

	public boolean isDeliverable() {
		return this.status.isSent();
	}

}
