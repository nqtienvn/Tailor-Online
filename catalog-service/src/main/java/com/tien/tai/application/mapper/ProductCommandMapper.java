package com.tien.tai.application.mapper;

import com.tien.tai.application.dto.request.ProductRequest;
import com.tien.tai.domain.command.ProductCmd;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductCommandMapper {
    ProductCmd from(ProductRequest productRequest);
}
