package com.tien.tai.application.service.command.impl;

import com.tien.common.domain.repository.CatalogDomainRepositoryCommon;
import com.tien.common.service.catalogservice.CatalogServiceCommand;
import com.tien.tai.application.dto.mapper.CategoryMapperDTO;
import com.tien.tai.application.dto.request.CategoryRequest;
import com.tien.tai.application.dto.response.CategoryResponse;
import com.tien.tai.application.mapper.CategoryCommandMapper;
import com.tien.tai.domain.command.CategoryCmd;
import com.tien.tai.domain.model.CategoryDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryCommandImpl implements CatalogServiceCommand<CategoryResponse, CategoryRequest, Integer> {
    private final CategoryCommandMapper categoryCommandMapper;
    private final CategoryMapperDTO categoryMapperDTO;
    private final CatalogDomainRepositoryCommon<CategoryDomain, Integer> catalogDomainRepositoryCommon;

    @Override
    public CategoryResponse create(CategoryRequest categoryRequest) {
        CategoryDomain category = new CategoryDomain(categoryCommandMapper.from(categoryRequest));
        return categoryMapperDTO.from(catalogDomainRepositoryCommon
                .save(category));
    }

    @Override
    public CategoryResponse update(CategoryRequest categoryRequest, Integer id) {
        CategoryCmd categoryCmd = categoryCommandMapper.from(categoryRequest);
        CategoryDomain domainFind = catalogDomainRepositoryCommon.findById(id);
        domainFind.update(categoryCmd);
        return categoryMapperDTO.from(catalogDomainRepositoryCommon.save(domainFind));
    }

    @Override
    public void softDelete(Integer id) {
        CategoryDomain domainFind = catalogDomainRepositoryCommon.findById(id);
        domainFind.softDelete();
        catalogDomainRepositoryCommon.softDelete(domainFind);
    }

    @Override
    public void inActive(Integer id) {
    }

    @Override
    public void active(Integer id) {
    }
}
