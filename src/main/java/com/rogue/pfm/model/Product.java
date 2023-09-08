package com.rogue.pfm.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

	@Id
	String uuid;

	@ManyToOne
	Category category;

	String title;

	@Column(columnDefinition = "TEXT")
	String body;

	@ElementCollection
	List<String> uuidsImages;

	public Product() {
		uuid = UUID.randomUUID().toString();
	}

	public Product(final String uuid, final Category category, final String title, final String body,
			final List<String> uuidsImage) {
		this.uuid = uuid;
		this.category = category;
		this.title = title;
		this.body = body;
		this.uuidsImages = uuidsImage;
	}
}
