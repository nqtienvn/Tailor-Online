package com.tien.tai.application.mapper;

import com.tien.tai.application.dto.request.CategorySearchRequest;
import com.tien.tai.domain.query.CategorySearchQuery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AutoMapperQuery {
    CategorySearchQuery from(CategorySearchRequest request);
}
