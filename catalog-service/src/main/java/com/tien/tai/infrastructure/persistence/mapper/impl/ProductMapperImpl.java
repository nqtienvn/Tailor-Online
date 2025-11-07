package com.tien.tai.infrastructure.persistence.mapper.impl;

import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.Product;
import com.tien.tai.infrastructure.persistence.model.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapperImpl implements ToEntityDomain<ProductEntity, Product> {
    @Override
    public ProductEntity toEntity(Product domain) {
        return ProductEntity.builder()
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
    public List<Product> toDomain(List<ProductEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return List.of();
        }
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Product toDomain(ProductEntity entity) {
        return Product.builder()
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
