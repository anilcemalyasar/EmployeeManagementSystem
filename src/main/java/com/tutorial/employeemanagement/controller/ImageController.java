package com.tutorial.employeemanagement.controller;

import com.tutorial.employeemanagement.model.entity.Image;
import com.tutorial.employeemanagement.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveImage(@RequestParam("image") MultipartFile image) {
        try {
            imageService.saveImage(image);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(image.getOriginalFilename());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Image> getImage(@PathVariable("id") Long id) {
        Image image;
        try {
            image = imageService.getOneImage(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(image);
    }
}
