package com.tutorial.employeemanagement.service;

import com.tutorial.employeemanagement.exception.image.ImageDoesNotExistException;
import com.tutorial.employeemanagement.model.entity.Image;
import com.tutorial.employeemanagement.repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image saveImage(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Image image = new Image(
                fileName,
                file.getContentType(),
                file.getBytes()
        );
        return imageRepository.save(image);
    }

    @Override
    public Image getOneImage(Long id) {
        imageRepository.findById(id)
                .orElseThrow(() -> new ImageDoesNotExistException(id));
        return imageRepository.findById(id).get();
    }
}
