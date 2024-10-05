package com.tutorial.employeemanagement.repository;

import com.tutorial.employeemanagement.model.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
