package com.com.app.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="shipping_tab")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="ship_type_col")
	private String shipType;

	@Column(name="ship_code_col")
	private String shipCode;
	
	@Column(name="ship_name_col")
	private String shipName;
	
	@Column(name="ship_cost_col")
	private String shipcost;
	
	@Column(name="ship_weight_col")
	private String shipWeight;
	
	
	@Column(name="id")
	private String shipWeightType;
	
	@Column(name="id")
	private String note;
}
