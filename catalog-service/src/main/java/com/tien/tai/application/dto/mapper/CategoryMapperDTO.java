package com.tien.tai.application.dto.mapper;

import com.tien.tai.application.dto.response.CategoryDTO;
import com.tien.tai.domain.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapperDTO {
    CategoryDTO from(Category category);

    List<CategoryDTO> toDTO(List<Category> categories);
}
