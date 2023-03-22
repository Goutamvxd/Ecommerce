package com.com.app.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="product_tab")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prod_id_col")
	private long id;
	
	@Column(name="prod_name_col")
	private String name;
	
	@Column(name="prod_short_desc_col")
	private String shortDesc;
	
	@Column(name="prod_full_desc_col")
	private String fullDesc;
	
	@Column(name="prod_status_col")
	private String status;
	
	@Column(name="prod_stock_col")
	private String inStock;
	
	@Column(name="prod_cost_col")
	private Double cost;
	
	@Column(name="prod_discount_col")
	private Double discount;
	
	@Column(name="prod_len_col")
	private Double len;
	
	@Column(name="prod_wid_col")
	private Double wid;
	
	@Column(name="prod_hght_col")
	private Double heigth;
	
	@Column(name="prod_dim_type_col")
	private String dimType;
	
	@Column(name="prod_wght_col")
	private Double weight;
	
	@Column(name="prod_wgtype_col")
	private String wigType;
	
	@Column(name="prod_note_col")
	private String note;
	
	@Column(name="prod_img_col")
	private String imageLink;
	
	@ManyToOne
	@JoinColumn(name="cat_id_fk_col")
	private Categoty catrgory;
	
	@ManyToOne
	@JoinColumn(name="brand_id_fk_col")
	private Brand brand;
	
}
