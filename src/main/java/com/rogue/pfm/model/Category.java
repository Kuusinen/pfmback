package com.rogue.pfm.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
public class Category {

	@Id
	String uuid;

	String name;

	@OneToOne
	Category category;

	String imageUuid;

	public Category() {
		this.uuid = UUID.randomUUID().toString();
	}
}
