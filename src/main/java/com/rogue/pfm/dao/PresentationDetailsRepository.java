package com.rogue.pfm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogue.pfm.model.Presentation;

public interface PresentationDetailsRepository extends JpaRepository<Presentation, String> {

}
