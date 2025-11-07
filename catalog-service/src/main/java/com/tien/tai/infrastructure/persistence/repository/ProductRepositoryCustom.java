package com.tien.tai.infrastructure.persistence.repository;

import com.tien.tai.domain.query.ProductSearchQuery;
import com.tien.tai.infrastructure.persistence.model.ProductEntity;

import java.util.List;

public interface ProductRepositoryCustom {
    Long count(ProductSearchQuery params);

    List<ProductEntity> search(ProductSearchQuery params);
}
