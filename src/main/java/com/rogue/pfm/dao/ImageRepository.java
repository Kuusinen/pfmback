package com.rogue.pfm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogue.pfm.model.Image;

public interface ImageRepository extends JpaRepository<Image, String> {

}
