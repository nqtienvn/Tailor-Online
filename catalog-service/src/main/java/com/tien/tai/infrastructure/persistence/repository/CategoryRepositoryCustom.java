package com.tien.tai.infrastructure.persistence.repository;

import com.tien.tai.domain.query.CategorySearchQuery;
import com.tien.tai.infrastructure.persistence.model.CategoryEntity;

import java.util.List;

public interface CategoryRepositoryCustom {
    Long count(CategorySearchQuery params);
    List<CategoryEntity> search(CategorySearchQuery params);
}
