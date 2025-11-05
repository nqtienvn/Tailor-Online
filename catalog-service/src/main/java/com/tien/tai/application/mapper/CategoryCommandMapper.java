package com.tien.tai.application.mapper;

import com.tien.tai.application.dto.request.CategoryRequest;
import com.tien.tai.domain.command.CategoryCmd;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryCommandMapper {
    CategoryCmd from(CategoryRequest categoryRequest);
}
