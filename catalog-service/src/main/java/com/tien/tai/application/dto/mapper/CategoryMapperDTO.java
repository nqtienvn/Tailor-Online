package com.tien.tai.application.dto.mapper;

import com.tien.tai.application.dto.response.CategoryResponse;
import com.tien.tai.domain.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapperDTO {
    CategoryResponse from(Category category);

    List<CategoryResponse> toDTO(List<Category> stamps);
}
