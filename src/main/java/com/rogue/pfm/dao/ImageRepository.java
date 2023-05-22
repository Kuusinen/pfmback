package com.rogue.pfm.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogue.pfm.model.Image;

public interface ImageRepository extends JpaRepository<Image, String> {

	Optional<Image> findByName(String name);
}
