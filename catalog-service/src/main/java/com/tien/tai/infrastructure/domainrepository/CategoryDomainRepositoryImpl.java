package com.tien.tai.infrastructure.domainrepository;

import com.tien.common.domain.repository.CatalogDomainRepositoryCommon;
import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.CategoryDomain;
import com.tien.tai.infrastructure.persistence.model.Category;
import com.tien.tai.infrastructure.persistence.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CategoryDomainRepositoryImpl implements CatalogDomainRepositoryCommon<CategoryDomain, Integer> {
    private final CategoryRepository categoryRepository;
    private final ToEntityDomain<Category, CategoryDomain> toEntityDomain;

    @Override
    public CategoryDomain save(CategoryDomain category) {
        Category savedEntity = categoryRepository.save(toEntityDomain.toEntity(category));
        return toEntityDomain.toDomain(savedEntity);
    }

    @Override
    public CategoryDomain findById(Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("category not found"));
        return toEntityDomain.toDomain(category);
    }

    @Override
    public void softDelete(CategoryDomain categoryDomain) {
        categoryRepository.save(toEntityDomain.toEntity(categoryDomain));
    }

    @Override
    public void saveStatus(CategoryDomain domain) {
    }
}
