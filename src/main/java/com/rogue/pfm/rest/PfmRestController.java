package com.rogue.pfm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rogue.pfm.model.CarouselElement;
import com.rogue.pfm.model.Category;
import com.rogue.pfm.model.Product;
import com.rogue.pfm.service.PfmApiService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PfmRestController {

	@Autowired
	PfmApiService pfmApiService;
	
	@GetMapping(value = "/carousel")
	public List<CarouselElement> getAllCarouselelement() {
		return pfmApiService.getAllCarouselElements();
	}

	@PostMapping(value = "/carousel")
	public void addCarouselElement(@RequestBody final CarouselElement carouselElement) {
		pfmApiService.addCarouselElement(carouselElement);
	}

	@DeleteMapping(value = "/carousel/remove")
	public void removeCarouselElement(@RequestBody final CarouselElement carouselElement) {
		pfmApiService.removeCarouselElement(carouselElement);
	}

	@GetMapping(value = "/category")
	public List<Category> getAllParentCategory() {
		return pfmApiService.getAllParentCategory();
	}

	@GetMapping(value = "/category/{categoryId}")
	public List<Category> getSubCategory(@PathVariable("categoryId") final String categoryId) {
		return pfmApiService.getAllCategoryByCategory(categoryId);
	}

	@GetMapping(value = "/product/{categoryId}")
	public List<Product> getProductByCategory(@PathVariable("categoryId") final String categoryId) {
		return pfmApiService.getAllproductByCategory(categoryId);
	}

	@GetMapping(value = "/product/id/{productId}")
	public Product getProductById(@PathVariable("productId") final String productId) {
		return pfmApiService.getProductById(productId);
	}

	@PostMapping(value = "/category")
	public void addCategory(@RequestBody final Category category) {
		pfmApiService.addCategory(category);
	}

	@DeleteMapping(value = "/category/remove")
	public void removeCategory(@RequestBody final Category category) {
		pfmApiService.removeCategory(category);
	}

	@GetMapping(value = "/category/id/{categoryId}")
	public Category getCategoryById(@PathVariable("categoryId") final String categoryId) {
		return pfmApiService.getCategoryById(categoryId);
	}

	@PostMapping(value = "/product")
	public void addProduct(@RequestBody final Product product) {
		pfmApiService.addProduct(product);
	}
}
