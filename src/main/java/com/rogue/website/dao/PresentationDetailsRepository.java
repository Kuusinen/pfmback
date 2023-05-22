package com.rogue.website.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogue.website.model.Presentation;

public interface PresentationDetailsRepository extends JpaRepository<Presentation, String> {

}
