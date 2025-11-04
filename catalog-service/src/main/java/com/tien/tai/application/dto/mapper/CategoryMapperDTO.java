package com.tien.tai.application.dto.mapper;

import com.tien.tai.application.dto.response.CategoryResponse;
import com.tien.tai.domain.model.CategoryDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapperDTO {
    CategoryResponse from(CategoryDomain category);
}
