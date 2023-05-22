package com.rogue.website.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogue.website.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
