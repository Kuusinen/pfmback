package com.rogue.demo.model;

import java.util.List;
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
public class Carousel {

	@Id
	String uuid;

	List<String> imageUuid;

	String imageDescription;

	public Carousel() {
		uuid = UUID.randomUUID().toString();
	}

	public Carousel(final String uuid, final List<String> imageUuid, final String imageDescription) {
		this.uuid = uuid;
		this.imageUuid = imageUuid;
		this.imageDescription = imageDescription;
	}
}
