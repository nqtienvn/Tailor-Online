package com.tien.tai.infrastructure.domainrepository;

import com.tien.tai.domain.model.CategoryDomain;
import com.tien.tai.domain.repository.CategoryDomainRepository;
import com.tien.tai.infrastructure.persistence.mapper.CategoryMapper;
import com.tien.tai.infrastructure.persistence.model.Category;
import com.tien.tai.infrastructure.persistence.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CategoryDomainRepositoryImpl implements CategoryDomainRepository {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    @Override
    public CategoryDomain save(CategoryDomain category) {
        Category savedEntity = categoryRepository.save(categoryMapper.toEntity(category));
        return categoryMapper.toDomain(savedEntity);
    }
}
