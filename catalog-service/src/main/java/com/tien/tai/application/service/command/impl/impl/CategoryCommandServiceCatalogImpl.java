package com.tien.tai.application.service.command.impl.impl;

import com.tien.common.domain.repository.DomainRepositoryCommon;
import com.tien.common.service.ServiceCatalogCommandCommon;
import com.tien.tai.application.dto.mapper.CategoryMapperDTO;
import com.tien.tai.application.dto.request.CategoryRequest;
import com.tien.tai.application.dto.response.CategoryDTO;
import com.tien.tai.application.mapper.CategoryCommandMapper;
import com.tien.tai.domain.command.CategoryCmd;
import com.tien.tai.domain.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryCommandServiceCatalogImpl implements ServiceCatalogCommandCommon<CategoryDTO, CategoryRequest, Integer> {
    private final CategoryCommandMapper categoryCommandMapper;
    private final CategoryMapperDTO categoryMapperDTO;
    private final DomainRepositoryCommon<Category, Integer> domainRepositoryCommon;

    @Override
    public CategoryDTO create(CategoryRequest categoryRequest) {
        Category category = new Category(categoryCommandMapper.from(categoryRequest));
        return categoryMapperDTO.from(domainRepositoryCommon
                .save(category));
    }

    @Override
    public CategoryDTO update(CategoryRequest categoryRequest, Integer id) {
        CategoryCmd categoryCmd = categoryCommandMapper.from(categoryRequest);
        Category domainFind = domainRepositoryCommon.findById(id);
        domainFind.update(categoryCmd);
        return categoryMapperDTO.from(domainRepositoryCommon.save(domainFind));
    }

    @Override
    public CategoryDTO detail(Integer id) {
        return categoryMapperDTO.from(domainRepositoryCommon.findById(id));
    }

    @Override
    public void softDelete(Integer id) {
        Category domainFind = domainRepositoryCommon.findById(id);
        domainFind.softDelete();
        domainRepositoryCommon.softDelete(domainFind);
    }

    @Override
    public void inActive(Integer id) {
    }

    @Override
    public void active(Integer id) {
    }
}
