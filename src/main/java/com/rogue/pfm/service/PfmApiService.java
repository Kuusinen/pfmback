package com.rogue.pfm.service;

import java.util.List;

import com.rogue.pfm.model.Carousel;
import com.rogue.pfm.model.Category;
import com.rogue.pfm.model.Presentation;
import com.rogue.pfm.model.Product;

public interface PfmApiService {

	Carousel getCarouselDetails(String id);

	List<Product> getProductByCategory(String categoryName);

	List<Category> getAllParentCategory();

	List<Category> getAllCategoryByCategory(String categoryName);

	Presentation getPresentationDetails(String id);
}
