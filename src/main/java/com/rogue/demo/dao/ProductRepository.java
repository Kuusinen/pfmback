package com.rogue.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogue.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
