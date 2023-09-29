package com.rogue.pfm.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
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
}
