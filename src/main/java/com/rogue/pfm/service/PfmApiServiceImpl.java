package com.rogue.pfm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogue.pfm.dao.CarouselElementRepository;
import com.rogue.pfm.dao.CategoryRepository;
import com.rogue.pfm.dao.ImageRepository;
import com.rogue.pfm.dao.PresentationDetailsRepository;
import com.rogue.pfm.dao.ProductRepository;
import com.rogue.pfm.model.CarouselElement;
import com.rogue.pfm.model.Category;
import com.rogue.pfm.model.Presentation;
import com.rogue.pfm.model.Product;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PfmApiServiceImpl implements PfmApiService {

	@Autowired
	CarouselElementRepository carouselRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	PresentationDetailsRepository detailsRepository;

	@Autowired
	ImageRepository imageRepository;

	@Override
	public List<Product> getProductByCategory(final String categoryName) {

		return productRepository.findByCategory(retrieveCategoryByName(categoryName));
	}

	private Category retrieveCategoryByName(final String categoryName) {
		final Optional<Category> categoryFind = categoryRepository.findByName(categoryName);
		return categoryFind.orElseGet(Category::new);
	}

	@Override
	public List<Category> getAllParentCategory() {
		return categoryRepository.findAllParentCategory();
	}

	@Override
	public List<Category> getAllCategoryByCategory(final String categoryId) {
		final List<Category> allSubCategory = new ArrayList<>();

		categoryRepository.findById(categoryId)
				.ifPresent(t -> allSubCategory.addAll(categoryRepository.findByCategory(t)));

		return allSubCategory;
	}

	@Override
	public List<Product> getAllproductByCategory(final String categoryId) {
		final List<Product> allProduct = new ArrayList<>();

		categoryRepository.findById(categoryId)
				.ifPresent(category -> allProduct.addAll(productRepository.findByCategory(category)));

		return allProduct;
	}

	@Override
	public Presentation getPresentationDetails(final String id) {
		final Optional<Presentation> presentationDetailsFind = detailsRepository.findById(id);
		return presentationDetailsFind.orElseGet(Presentation::new);
	}

	@Override
	public List<CarouselElement> getAllCarouselElements() {
		return carouselRepository.findAll();
	}

	@Override
	public void addCarouselElement(final CarouselElement carouselElement) {
		carouselRepository.save(carouselElement);
	}

	@Override
	public void removeCarouselElement(final CarouselElement carouselElement) {
		carouselRepository.delete(carouselElement);
		imageRepository.deleteById(carouselElement.getImageUuid());
	}

	@Override
	public void addCategory(final Category category) {
		categoryRepository.save(category);
	}

	@Override
	public void removeCategory(final Category category) {
		final List<Category> allCategoryToRemove = new ArrayList<>();

		allCategoryToRemove.addAll(retrieveAllCategoryToRemove(category));

		for (int i = allCategoryToRemove.size() - 1; i >= 0; i--) {
			categoryRepository.delete(allCategoryToRemove.get(i));
			imageRepository.deleteById(allCategoryToRemove.get(i).getImageUuid());
		}
	}

	private List<Category> retrieveAllCategoryToRemove(final Category category){
		final List<Category> allCategoryToRemove = new ArrayList<>();

		allCategoryToRemove.add(category);

		if (getAllCategoryByCategory(category.getUuid()).isEmpty()) {
			return allCategoryToRemove;
		} else {
			for (final Category subCat : getAllCategoryByCategory(category.getUuid())) {
				allCategoryToRemove.addAll(retrieveAllCategoryToRemove(subCat));
			}
		}

		return allCategoryToRemove;
	}
}
