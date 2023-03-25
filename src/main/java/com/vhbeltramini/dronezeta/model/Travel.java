package com.vhbeltramini.dronezeta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;


@Entity
public class Travel {
	@Id
	@GeneratedValue
	private Integer id;

	@OneToMany
	private List<Product> products;

	private TravelStatus status;

	public Travel() {}

	public Travel(List<Product> products, TravelStatus status) {
		super();
		this.products = products;
		this.status = status;
	}

	public enum TravelStatus {
		WAITING_TO_DELIVERY (3, "Aguardando pagamento."){
			@Override
			public boolean isWaitingToDelivery() {
				return true;
			}
		},
		TRAVELING (2, "Pagamento Confirmado"){
			@Override
			public boolean isTreveling() {
				return true;
			}
		},
		DELIVERED (1, "Entregue"){
			@Override
			public boolean isDelivered() {
				return true;
			}
		};

		private String description;
		private Integer statusID;

		public boolean isTreveling() {return false;}

		public boolean isDelivered() {return false;}

		public boolean isWaitingToDelivery(){return false;}

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
