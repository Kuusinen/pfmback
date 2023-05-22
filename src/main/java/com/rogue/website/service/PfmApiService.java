package com.rogue.website.service;

import java.util.List;

import com.rogue.website.model.Carousel;
import com.rogue.website.model.Category;
import com.rogue.website.model.Presentation;
import com.rogue.website.model.Product;

public interface PfmApiService {

	Carousel getCarouselDetails(String id);

	List<Product> getProductByCategory(String categoryName);

	List<Category> getAllParentCategory();

	List<Category> getAllCategoryByCategory(String categoryName);

	Presentation getPresentationDetails(String id);
}
