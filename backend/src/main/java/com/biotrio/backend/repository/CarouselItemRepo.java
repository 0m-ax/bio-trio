package com.biotrio.backend.repository;

import com.biotrio.backend.model.CarouselItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarouselItemRepo extends JpaRepository<CarouselItem, Integer> {
}
