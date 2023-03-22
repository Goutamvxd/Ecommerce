package com.com.app.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Table(name="categorytype_tab")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryType {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="cat_type_name_col")
	private String name;
	
	@Column(name="cat_type_note_col")
	private String note;
}
