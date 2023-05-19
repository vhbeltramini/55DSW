package com.vhbeltramini.dronezeta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;


@Entity
public class Travel {
	@Id
	@GeneratedValue
	private Integer id;

	@OneToMany
	private List<Product> products;

	private TravelStatus status;

	private String timeToDelivery;

	public Travel() {}

	public Travel(List<Product> products, TravelStatus status) {
		super();
		this.products = products;
		this.status = status;
		this.timeToDelivery = LocalDateTime.now().plusMinutes(2).toString();
	}

	public enum TravelStatus {
		SENT(1, "Enviado."){
			@Override
			public boolean isTreveling() {
				return true;
			}
		},
		DELIVERED (2, "Entregue."){
			@Override
			public boolean isDelivered() {
				return true;
			}
		};

		private String description;
		private Integer statusID;

		public boolean isTreveling() {return false;}

		public boolean isDelivered() {return false;}


		public String getDescription() {
			return description;
		}

		public Integer getStatusID() {
			return statusID;
		}

		TravelStatus(Integer id, String description) {
			this.statusID = id;
			this.description = description;
		}
	}

	public boolean isDelivered() {
		return this.status.isDelivered();
	}



}
