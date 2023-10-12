package com.rogue.pfm.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rogue.pfm.model.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {

	Optional<Category> findByName(String name);

	List<Category> findByCategory(Category category);

	@Query(value = "SELECT c FROM Category c WHERE c.category = NULL")
	List<Category> findAllParentCategory();
}
