package com.hcl.miniproject.entities;

/*
 * Author: Ramesh
 * class name: orderDetails entity class  
 * purpose:declaring order instance variable and we can access object anywhere in the projects
 */
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OrderDetails_Table")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	private String userName;
	private String itemName;
	private int totalAmount;
	private int plates;
	private LocalDate date;

	public OrderDetails() {
		super();
	}

	public OrderDetails(long orderId, String userName, String itemName, int totalAmount, int plates, LocalDate date) {
		super();
		this.orderId = orderId;
		this.userName = userName;
		this.itemName = itemName;
		this.totalAmount = totalAmount;
		this.plates = plates;
		this.date = date;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getPlates() {
		return plates;
	}

	public void setPlates(int plates) {
		this.plates = plates;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", userName=" + userName + ", itemName=" + itemName
				+ ", totalAmount=" + totalAmount + ", plates=" + plates + ", date=" + date + "]";
	}

}