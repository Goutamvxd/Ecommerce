package com.com.app.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="brandtab")
public class Brand {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="brnd_id_col")
	private Long id;
	
	@Column(name="brnd_name_col")
	private String name;
	
	@Column(name="brnd_code_col")
	private String code;
	
	@Column(name="brnd_tagline_col")
	private String tagLine;
	
	@Column(name="brnd_image_col")
	private String imageLink;
	
	@Column(name="brnd_note_col")
	private String note;
}
