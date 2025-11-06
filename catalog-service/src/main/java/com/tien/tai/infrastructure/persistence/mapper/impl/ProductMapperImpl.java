package com.tien.tai.infrastructure.persistence.mapper.impl;

import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.ProductDomain;
import com.tien.tai.infrastructure.persistence.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ToEntityDomain<Product, ProductDomain> {
    @Override
    public Product toEntity(ProductDomain domain) {
        return Product.builder()
                .id(domain.getId())
                .name(domain.getName())
                .categoryId(domain.getCategoryId())
                .basePrice(domain.getBasePrice())
                .fabricId(domain.getFabricId())
                .status(domain.getStatus())
                .isDeleted(domain.getIsDeleted())
                .description(domain.getDescription())
                .build();
    }

    @Override
    public ProductDomain toDomain(Product entity) {
        return ProductDomain.builder()
                .id(entity.getId())
                .name(entity.getName())
                .categoryId(entity.getCategoryId())
                .basePrice(entity.getBasePrice())
                .fabricId(entity.getFabricId())
                .status(true)
                .isDeleted(false)
                .description(entity.getDescription())
                .build();
    }
}
