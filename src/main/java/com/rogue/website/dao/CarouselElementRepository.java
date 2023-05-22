package com.rogue.website.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogue.website.model.CarouselElement;

public interface CarouselElementRepository extends JpaRepository<CarouselElement, String> {

}
