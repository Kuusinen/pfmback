package com.rogue.pfm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogue.pfm.model.Category;
import com.rogue.pfm.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

	List<Product> findByCategory(Category category);
}
