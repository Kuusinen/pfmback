package com.rogue.pfm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rogue.pfm.model.CarouselElement;
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
}
