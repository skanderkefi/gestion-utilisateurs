package com.gec.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gec.model.ImageModel;


public interface ImageRepository extends JpaRepository<ImageModel, Long> {
}
