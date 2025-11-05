package com.tien.tai.domain.repository;

import com.tien.tai.domain.model.CategoryDomain;

public interface CategoryDomainRepository {
    CategoryDomain save(CategoryDomain category);
    CategoryDomain findById(Integer id);
    void softDelete(CategoryDomain categoryDomain);
}
