package com.rogue.website.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogue.website.model.Image;

public interface ImageRepository extends JpaRepository<Image, String> {

	Optional<Image> findByName(String name);
}
