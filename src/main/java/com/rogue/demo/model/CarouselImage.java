package com.rogue.demo.model;

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
public class CarouselImage {

	@Id
	String uuid;

	String imageUuid;

	String imageDescription;

	public CarouselImage() {
		uuid = UUID.randomUUID().toString();
	}

	public CarouselImage(final String uuid, final String imageUuid, final String imageDescription) {
		this.uuid = uuid;
		this.imageUuid = imageUuid;
		this.imageDescription = imageDescription;
	}
}
