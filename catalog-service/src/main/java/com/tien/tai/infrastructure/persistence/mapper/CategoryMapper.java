package com.tien.tai.infrastructure.persistence.mapper;

import com.tien.tai.domain.model.CategoryDomain;
import com.tien.tai.infrastructure.persistence.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryDomain category);

    CategoryDomain toDomain(Category category);
}
