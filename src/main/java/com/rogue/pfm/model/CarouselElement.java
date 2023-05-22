package com.rogue.pfm.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class CarouselElement {

	@Id
	String id;

	String imageUuid;

	String imageDescription;

	public CarouselElement() {
		this.id = UUID.randomUUID().toString();
	}

	public CarouselElement(final String id, final String imageUuid, final String imageDescription) {
		this.id = id;
		this.imageUuid = imageUuid;
		this.imageDescription = imageDescription;
	}
}
