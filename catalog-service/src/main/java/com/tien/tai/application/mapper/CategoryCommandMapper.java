package com.tien.tai.application.mapper;

import com.tien.tai.application.dto.request.CategoryCreateRequest;
import com.tien.tai.domain.command.CategoryCreateCmd;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryCommandMapper {
    CategoryCreateCmd from(CategoryCreateRequest categoryCreateRequest);
}
