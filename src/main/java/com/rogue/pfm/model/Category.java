package com.rogue.pfm.model;

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
@Getter
@Setter
public class Category {

	@Id
	String uuid;

	String name;

	@OneToOne
	Category category;

	String imageUUid;

	public Category() {
		this.uuid = UUID.randomUUID().toString();
	}

	public Category(final String uuid, final String name, final Category category, final String imageUuid) {
		this.uuid = uuid;
		this.name = name;
		this.category = category;
		this.imageUUid = imageUuid;
	}

}