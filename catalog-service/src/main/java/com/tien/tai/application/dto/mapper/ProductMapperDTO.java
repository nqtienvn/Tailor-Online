package com.tien.tai.application.dto.mapper;

import com.tien.tai.application.dto.response.ProductResponse;
import com.tien.tai.domain.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapperDTO {
    ProductResponse from(Product product);
}
