package com.rogue.website.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogue.website.dao.CarouselRepository;
import com.rogue.website.dao.CategoryRepository;
import com.rogue.website.dao.PresentationDetailsRepository;
import com.rogue.website.dao.ProductRepository;
import com.rogue.website.model.Carousel;
import com.rogue.website.model.Category;
import com.rogue.website.model.Presentation;
import com.rogue.website.model.Product;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PfmApiServiceImpl implements PfmApiService {

	@Autowired
	CarouselRepository carouselRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	PresentationDetailsRepository detailsRepository;

	@Override
	public Carousel getCarouselDetails(final String id) {
		final Optional<Carousel> carouselFind = carouselRepository.findById(id);
		return carouselFind.orElseGet(Carousel::new);
	}

	@Override
	public List<Product> getProductByCategory(final String categoryName) {

		return productRepository.findByCategory(retrieveCategoryByName(categoryName));
	}

	@Override
	public List<Category> getAllParentCategory() {
		return categoryRepository.findAllParentCategory();
	}

	@Override
	public List<Category> getAllCategoryByCategory(final String categoryName) {
		return categoryRepository.findByCategory(retrieveCategoryByName(categoryName));
	}

	private Category retrieveCategoryByName(final String categoryName) {
		final Optional<Category> categoryFind = categoryRepository.findByName(categoryName);
		return categoryFind.orElseGet(Category::new);
	}

	@Override
	public Presentation getPresentationDetails(final String id) {
		final Optional<Presentation> presentationDetailsFind = detailsRepository.findById(id);
		return presentationDetailsFind.orElseGet(Presentation::new);
	}

}
