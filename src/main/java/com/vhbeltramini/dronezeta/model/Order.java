package com.vhbeltramini.dronezeta.model;

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
	private Client client;

	@OneToOne
	private PaymentMethod paymentMethod;

	private OrderStatus status;

	@OneToOne
	private Delivery delivery;

	public Order() {}

	public Order(List<Product> products, Date date, Client client, PaymentMethod paymentMethod, OrderStatus status) {
		super();
		this.products = products;
		this.date = date;
		this.client = client;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

	public enum OrderStatus {
		WAITING_PAYMENT (5, "Aguardando pagamento.", 60){
			@Override
			public boolean isWaitingForPayment() {
				return true;
			}
		},
		PAYMENT_CONFIRMED (4, "Pagamento Confirmado", 60){
			@Override
			public boolean isPaymentConfirmed() {
				return true;
			}
		},
		READY (3, "Pronto para envio", 60){
			@Override
			public boolean isReadyToSent() {
				return true;
			}
		},
		SENT (2, "Enviado", 60){
			@Override
			public boolean isSent() {
				return true;
			}
		},
		DELIVERED (1, "Entregue", 0){
			@Override
			public boolean isDelivered() {
				return true;
			}
		};

		private int timeToDelivery;
		private String description;
		private Integer statusID;

		public boolean isPaymentConfirmed() {
			return false;
		}

		public boolean isSent() {
			return false;
		}

		public boolean isReadyToSent() {
			return false;
		}

		public boolean isWaitingForPayment() {
			return false;
		}

		public boolean isDelivered() {
			return false;
		}

		public String getDescription() {
			return description;
		}

		public Integer getTimeToDelivery() {
			return timeToDelivery;
		}

		public Integer getStatusID() {
			return statusID;
		}

		OrderStatus(Integer id, String description, Integer timeToDelivery) {
			this.statusID = id;
			this.description = description;
			this.timeToDelivery = timeToDelivery;
		}
	}

	public void printTimeToDeliver() {
		System.out.println("Time to delivery is " +
				this.getStatus().getTimeToDelivery());
	}

	public boolean isDeliverable() {
		return this.status.isSent();
	}

}
