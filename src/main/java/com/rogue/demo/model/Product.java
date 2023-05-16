package com.rogue.demo.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Product {

	@Id
	String uuid;

	@OneToOne
	Category category;

	boolean newProduct;

	String title;

	String body;

	LocalDate date;

	List<String> imageName;

}
