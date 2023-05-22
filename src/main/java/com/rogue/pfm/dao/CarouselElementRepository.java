package com.rogue.pfm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogue.pfm.model.CarouselElement;

public interface CarouselElementRepository extends JpaRepository<CarouselElement, String> {

}
