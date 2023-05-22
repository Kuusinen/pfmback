package com.rogue.website.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogue.website.model.Category;
import com.rogue.website.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

	List<Product> findByCategory(Category category);
}
