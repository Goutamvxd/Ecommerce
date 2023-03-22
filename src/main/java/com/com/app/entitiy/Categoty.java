package com.com.app.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="category_tab")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="cat_name_col")
	private String name;
	
	@Column(name="cat_alias_col")
	private String alias;
	
	@Column(name="cat_status_col")
	private String status;
	
	@Column(name="cat_note_col")
	private String note;
	
	@ManyToOne
	@JoinColumn(name="cat_type_fk_col")
	private CategoryType categoryType;
}
