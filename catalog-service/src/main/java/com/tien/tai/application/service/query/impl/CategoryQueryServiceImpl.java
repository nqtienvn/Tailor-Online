package com.tien.tai.application.service.query.impl;

import com.tien.common.dto.response.PageDTO;
import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.common.service.ServiceQueryCommon;
import com.tien.tai.application.dto.mapper.CategoryMapperDTO;
import com.tien.tai.application.dto.request.CategorySearchRequest;
import com.tien.tai.application.dto.response.CategoryResponse;
import com.tien.tai.application.mapper.AutoMapperQuery;
import com.tien.tai.domain.model.Category;
import com.tien.tai.domain.query.CategorySearchQuery;
import com.tien.tai.domain.repository.CategoryDomainRepository;
import com.tien.tai.infrastructure.persistence.model.CategoryEntity;
import com.tien.tai.infrastructure.persistence.repository.CategoryRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CategoryQueryServiceImpl implements ServiceQueryCommon<PageDTO<CategoryResponse>, CategorySearchRequest> {
    private final CategoryMapperDTO categoryMapperDTO;
    private final CategoryDomainRepository categoryDomainRepository;
    private final AutoMapperQuery autoMapperQuery;
    private final CategoryRepositoryCustom categoryRepositoryCustom;
    private final ToEntityDomain<CategoryEntity, Category> toEntityDomain;

    @Override
    public PageDTO<CategoryResponse> search(CategorySearchRequest request) {
        CategorySearchQuery searchQuery = this.autoMapperQuery.from(request);
        Long total = this.categoryRepositoryCustom.count(searchQuery);
        if (Objects.equals(total, 0L)) {
            return PageDTO.empty();
        }
        List<Category> categories = this.toEntityDomain.toDomain(this.categoryRepositoryCustom.search(searchQuery));
        List<CategoryResponse> categoryDtos = this.categoryMapperDTO.toDTO(categories);
        this.categoryDomainRepository.enrichDTO(categoryDtos);
        return new PageDTO<>(categoryDtos, request.getPageIndex(), request.getPageSize(), total);
    }
}
