package com.tien.tai.application.mapper;

import com.tien.tai.application.dto.request.CategorySearchRequest;
import com.tien.tai.application.dto.request.FabricSearchRequest;
import com.tien.tai.application.dto.request.ProductSearchRequest;
import com.tien.tai.domain.query.CategorySearchQuery;
import com.tien.tai.domain.query.FabricSearchQuery;
import com.tien.tai.domain.query.ProductSearchQuery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AutoMapperQuery {
    CategorySearchQuery from(CategorySearchRequest request);
    FabricSearchQuery from(FabricSearchRequest request);
    ProductSearchQuery from(ProductSearchRequest request);
}
