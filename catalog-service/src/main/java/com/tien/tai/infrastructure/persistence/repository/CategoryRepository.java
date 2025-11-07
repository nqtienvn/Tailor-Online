package com.tien.tai.infrastructure.persistence.repository;

import com.tien.tai.infrastructure.persistence.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
