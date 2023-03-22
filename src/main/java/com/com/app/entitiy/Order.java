package com.com.app.entitiy;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="order_tab")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="order_id_col")
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="order_id_fk_col")
	private List<OrderItem> orderItems;
	
	@ManyToOne
	@JoinColumn(name="cust_id_fk_col")
	private Customer customer;
	
	@Column(name="order_status_col")
	private String status;
	
	@Column(name="order_grand_total_col")
	private Double grandTotal;
	
	@Column(name="ord_coupon_id_fk_col")
	private Coupon coupon;
	
	@Column(name="order_coupon_col")
	private Double couponAmt;
	
	@Column(name="order_billing_amt_col")
	private Double billingAmt;
}
