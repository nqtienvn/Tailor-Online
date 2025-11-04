package com.tien.tai.infrastructure.persistence.repository;

import com.tien.tai.infrastructure.persistence.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
