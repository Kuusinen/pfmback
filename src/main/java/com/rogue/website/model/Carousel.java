package com.rogue.website.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Carousel {

	@Id
	String uuid;

	@OneToMany
	List<CarouselElement> carouselElements;

	public Carousel() {
		uuid = UUID.randomUUID().toString();
	}

	public Carousel(final String uuid, final List<CarouselElement> carouselElements) {
		super();
		this.uuid = uuid;
		this.carouselElements = carouselElements;
	}
}
