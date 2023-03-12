package com.pool.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MQ_ORDERS")
public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8771328656372412296L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	private String itemName;
	private String orderPrice;

	public Order() {
	}

	public Integer getOrderId() {
		return orderId;
	}

	public Order setOrderId(Integer orderId) {
		this.orderId = orderId;
		return this;
	}

	public String getItemName() {
		return itemName;
	}

	public Order setItemName(String itemName) {
		this.itemName = itemName;
		return this;
	}

	public String getOrderPrice() {
		return orderPrice;
	}

	public Order setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
		return this;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", itemName=" + itemName + ", orderPrice=" + orderPrice + "]";
	}
}
