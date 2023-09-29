package com.rogue.pfm.service;

import java.util.List;

import com.rogue.pfm.model.CarouselElement;
import com.rogue.pfm.model.Category;
import com.rogue.pfm.model.Email;
import com.rogue.pfm.model.Presentation;
import com.rogue.pfm.model.Product;

public interface PfmApiService {

	List<CarouselElement> getAllCarouselElements();

	List<Product> getProductsByCategory(String categoryName);

	List<Category> getAllParentCategory();

	List<Category> getAllCategoryByCategory(String categoryId);

	List<Product> getAllproductByCategory(String categoryId);

	Presentation getPresentationDetails(String id);

	void addCarouselElement(CarouselElement carouselElement);

	void removeCarouselElement(CarouselElement carouselElement);

	void addCategory(Category category);

	void removeCategory(Category category);

	Product getProductById(String productId);

	Category getCategoryById(String categoryId);

	Category getCategoryByName(String categoryName);

	void addProduct(Product product);

	void sendEmail(Email email);
}
