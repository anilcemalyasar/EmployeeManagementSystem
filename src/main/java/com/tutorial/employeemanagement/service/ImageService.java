package com.tutorial.employeemanagement.service;

import com.tutorial.employeemanagement.model.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    Image saveImage(MultipartFile file) throws IOException;
    Image getOneImage(Long id);
}
