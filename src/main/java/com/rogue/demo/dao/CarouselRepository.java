package com.rogue.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogue.demo.model.Carousel;

public interface CarouselRepository extends JpaRepository<Carousel, String> {

	List<String> findImageUuid();

}
