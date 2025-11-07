package com.tien.tai.infrastructure.persistence.mapper.impl;

import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.Category;
import com.tien.tai.infrastructure.persistence.model.CategoryEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapperImpl implements ToEntityDomain<CategoryEntity, Category> {
    @Override
    public CategoryEntity toEntity(Category category) {
        return CategoryEntity.builder()
                .id(category.getId())
                .name(category.getName())
                .isDeleted(category.getIsDeleted())
                .build();
    }

    @Override
    public List<Category> toDomain(List<CategoryEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return List.of();
        }
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Category toDomain(CategoryEntity categoryEntity) {
        return Category.builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .isDeleted(categoryEntity.getIsDeleted())
                .build();
    }
}
