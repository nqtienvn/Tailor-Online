package com.tien.tai.application.service.command.impl;

import com.tien.tai.application.dto.mapper.CategoryMapperDTO;
import com.tien.tai.application.dto.request.CategoryRequest;
import com.tien.tai.application.dto.response.CategoryResponse;
import com.tien.tai.application.mapper.CategoryCommandMapper;
import com.tien.tai.application.service.command.CategoryCommandService;
import com.tien.tai.domain.command.CategoryCmd;
import com.tien.tai.domain.model.CategoryDomain;
import com.tien.tai.domain.repository.CategoryDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryCommandServiceImpl implements CategoryCommandService {
    private final CategoryCommandMapper categoryCommandMapper;
    private final CategoryDomainRepository categoryDomainRepository;
    private final CategoryMapperDTO categoryMapperDTO;

    @Override
    public CategoryResponse create(CategoryRequest categoryRequest) {
        CategoryDomain category = new CategoryDomain(categoryCommandMapper.from(categoryRequest));
        return categoryMapperDTO.from(categoryDomainRepository
                .save(category));
    }

    @Override
    public CategoryResponse update(CategoryRequest categoryRequest, Integer id) {
        CategoryCmd categoryCmd = categoryCommandMapper.from(categoryRequest);
        CategoryDomain domainFind = categoryDomainRepository.findById(id);
        domainFind.update(categoryCmd);
        return categoryMapperDTO.from(categoryDomainRepository.save(domainFind));
    }

    @Override
    public void softDelete(Integer id) {
        CategoryDomain domainFind = categoryDomainRepository.findById(id);
        domainFind.softDelete();
        categoryDomainRepository.softDelete(domainFind);
    }
}
