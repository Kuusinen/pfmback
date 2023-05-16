package com.rogue.demo.model;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

	@Id
	@Getter
	@Setter
	String uuid;

	@Getter
	@Setter
	@OneToOne
	Category category;

	@Getter
	@Setter
	boolean newProduct;

	@Getter
	@Setter
	String title;

	@Getter
	@Setter
	String body;

	@Getter
	@Setter
	LocalDate date;

	List<String> uuidsImage;

	public Product() {
		uuid = UUID.randomUUID().toString();
	}

	public Product(final String uuid, final Category category, final boolean newProduct, final String title,
			final String body, final LocalDate date, final List<String> uuidsImage) {
		this.uuid = uuid;
		this.category = category;
		this.newProduct = newProduct;
		this.title = title;
		this.body = body;
		this.date = date;
		this.uuidsImage = uuidsImage;
	}

	public List<String> getUuidsImage() {
		return Collections.unmodifiableList(uuidsImage);
	}

	public void setUuidsImage(List<String> uuidsImage) {
		this.uuidsImage = uuidsImage;
	}

}
