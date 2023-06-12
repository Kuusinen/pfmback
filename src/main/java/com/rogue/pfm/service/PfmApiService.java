package com.rogue.pfm.service;

import java.util.List;

import com.rogue.pfm.model.CarouselElement;
import com.rogue.pfm.model.Category;
import com.rogue.pfm.model.Presentation;
import com.rogue.pfm.model.Product;

public interface PfmApiService {

	List<CarouselElement> getAllCarouselElements();

	List<Product> getProductByCategory(String categoryName);

	List<Category> getAllParentCategory();

	List<Category> getAllCategoryByCategory(String categoryName);

	Presentation getPresentationDetails(String id);

	void addCarouselElement(CarouselElement carouselElement);

	void removeCarouselElement(CarouselElement carouselElement);
}
