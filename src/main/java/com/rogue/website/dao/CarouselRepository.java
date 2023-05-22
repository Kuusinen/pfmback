package com.rogue.website.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogue.website.model.Carousel;

public interface CarouselRepository extends JpaRepository<Carousel, String> {

}
