package com.tien.tai.infrastructure.persistence.mapper.impl;

import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.CategoryDomain;
import com.tien.tai.infrastructure.persistence.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperImpl implements ToEntityDomain<Category, CategoryDomain> {
    @Override
    public Category toEntity(CategoryDomain category) {
        return Category.builder()
                .id(category.getId())
                .name(category.getName())
                .isDeleted(category.getIsDeleted())
                .build();
    }

    @Override
    public CategoryDomain toDomain(Category category) {
        return CategoryDomain.builder()
                .id(category.getId())
                .name(category.getName())
                .isDeleted(category.getIsDeleted())
                .build();
    }
}
