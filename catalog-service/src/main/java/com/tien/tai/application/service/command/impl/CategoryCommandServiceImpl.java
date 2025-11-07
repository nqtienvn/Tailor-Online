package com.tien.tai.application.service.command.impl;

import com.tien.common.domain.repository.DomainRepositoryCommon;
import com.tien.common.service.ServiceCommandCommon;
import com.tien.tai.application.dto.mapper.CategoryMapperDTO;
import com.tien.tai.application.dto.request.CategoryRequest;
import com.tien.tai.application.dto.response.CategoryResponse;
import com.tien.tai.application.mapper.CategoryCommandMapper;
import com.tien.tai.domain.command.CategoryCmd;
import com.tien.tai.domain.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryCommandServiceImpl implements ServiceCommandCommon<CategoryResponse, CategoryRequest, Integer> {
    private final CategoryCommandMapper categoryCommandMapper;
    private final CategoryMapperDTO categoryMapperDTO;
    private final DomainRepositoryCommon<Category, Integer> domainRepositoryCommon;

    @Override
    public CategoryResponse create(CategoryRequest categoryRequest) {
        Category category = new Category(categoryCommandMapper.from(categoryRequest));
        return categoryMapperDTO.from(domainRepositoryCommon
                .save(category));
    }

    @Override
    public CategoryResponse update(CategoryRequest categoryRequest, Integer id) {
        CategoryCmd categoryCmd = categoryCommandMapper.from(categoryRequest);
        Category domainFind = domainRepositoryCommon.findById(id);
        domainFind.update(categoryCmd);
        return categoryMapperDTO.from(domainRepositoryCommon.save(domainFind));
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
