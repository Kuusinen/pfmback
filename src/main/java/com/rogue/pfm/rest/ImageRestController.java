package com.rogue.pfm.rest;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rogue.pfm.dao.ImageRepository;
import com.rogue.pfm.model.Image;
import com.rogue.pfm.model.ImageUploadResponse;
import com.rogue.pfm.util.ImageUtil;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@RestController
@CrossOrigin("*")
@RequestMapping("/image")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageRestController {

	@Autowired
	ImageRepository imageRepository;

	@PostMapping("/upload")
	public ResponseEntity<ImageUploadResponse> uplaodImage(@RequestParam("image") final MultipartFile file)
			throws IOException {

		final Image image = new Image();
		image.setContent(ImageUtil.compressImage(file.getBytes()));
		image.setName(file.getOriginalFilename());
		image.setContentType(file.getContentType());
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ImageUploadResponse("Image uploaded successfully: " + file.getOriginalFilename()));
	}

	@GetMapping(path = { "/info/{name}" })
	public Image getImageDetails(@PathVariable("name") final String name) throws IOException {

		final Optional<Image> dbImage = imageRepository.findByName(name);

		final Image image = new Image();
		image.setContent(ImageUtil.compressImage(dbImage.get().getContent()));
		image.setName(dbImage.get().getName());
		return image;
	}

	@GetMapping(path = { "/{name}" })
	public ResponseEntity<byte[]> getImage(@PathVariable("name") final String name) throws IOException {

		final Optional<Image> dbImage = imageRepository.findByName(name);

		return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.get().getContentType()))
				.body(ImageUtil.decompressImage(dbImage.get().getContent()));
	}
}