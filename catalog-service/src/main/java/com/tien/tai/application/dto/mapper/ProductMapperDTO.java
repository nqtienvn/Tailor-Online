package com.tien.tai.application.dto.mapper;

import com.tien.tai.application.dto.response.ProductDTO;
import com.tien.tai.domain.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapperDTO {
    ProductDTO from(Product product);

    List<ProductDTO> toDTO(List<Product> products);
}
