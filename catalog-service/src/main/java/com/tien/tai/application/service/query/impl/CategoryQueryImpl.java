package com.tien.tai.application.service.query.impl;

import com.tien.common.domain.repository.DomainRepositoryCommon;
import com.tien.common.service.ServiceQueryCommon;
import com.tien.tai.application.dto.mapper.CategoryMapperDTO;
import com.tien.tai.application.dto.response.CategoryResponse;
import com.tien.tai.application.mapper.CategoryCommandMapper;
import com.tien.tai.domain.model.CategoryDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryQueryImpl implements ServiceQueryCommon<Page<CategoryResponse>, Integer> {
    private final CategoryCommandMapper categoryCommandMapper;
    private final CategoryMapperDTO categoryMapperDTO;
    private final DomainRepositoryCommon<CategoryDomain, Integer> domainRepositoryCommon;
    @Override
    public Page<CategoryResponse> getAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);

        return null;
    }
}
