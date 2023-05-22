package com.rogue.website.model;

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
public class Presentation {

	@Id
	String id;

	String description;

	public Presentation() {
		this.id = UUID.randomUUID().toString();
	}

	public Presentation(final String id, final String description) {
		this.id = id;
		this.description = description;
	}
}
