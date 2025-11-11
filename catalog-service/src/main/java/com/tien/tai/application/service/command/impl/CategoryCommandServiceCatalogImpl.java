package com.tien.tai.application.service.command.impl;

import com.tien.common.service.ServiceCatalogCommandCommon;
import com.tien.tai.application.dto.mapper.CategoryMapperDTO;
import com.tien.tai.application.dto.request.CategoryRequest;
import com.tien.tai.application.dto.response.CategoryDTO;
import com.tien.tai.application.mapper.CategoryCommandMapper;
import com.tien.tai.domain.command.CategoryCmd;
import com.tien.tai.domain.model.Category;
import com.tien.tai.domain.repository.CategoryDomainRepository;
import com.tien.tai.domain.repository.ProductDomainRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryCommandServiceCatalogImpl implements ServiceCatalogCommandCommon<CategoryDTO, CategoryRequest, Integer> {
    private final CategoryCommandMapper categoryCommandMapper;
    private final CategoryMapperDTO categoryMapperDTO;
    private final CategoryDomainRepository categoryDomainRepository;
    private final ProductDomainRepository productDomainRepository;

    @Override
    @Transactional
    public CategoryDTO create(CategoryRequest categoryRequest) {
        Category category = new Category(categoryCommandMapper.from(categoryRequest));
        return categoryMapperDTO.from(categoryDomainRepository
                .save(category));
    }

    @Override
    public CategoryDTO update(CategoryRequest categoryRequest, Integer id) {
        CategoryCmd categoryCmd = categoryCommandMapper.from(categoryRequest);
        Category domainFind = categoryDomainRepository.findById(id);
        domainFind.update(categoryCmd);
        return categoryMapperDTO.from(categoryDomainRepository.save(domainFind));
    }

    @Override
    public CategoryDTO detail(Integer id) {
        Category categoryDetail = categoryDomainRepository.findById(id);
        CategoryDTO categoryDTO = categoryMapperDTO.from(categoryDetail);
        categoryDomainRepository.enrichDTO(List.of(categoryDTO));
        return categoryDTO;
    }

    @Override
    public void softDelete(Integer id) {
        Category domainFind = categoryDomainRepository.findById(id);
        domainFind.softDelete();
        categoryDomainRepository.softDelete(domainFind);
    }

    @Override
    public void inActive(Integer id) {
    }

    @Override
    public void active(Integer id) {
    }
}
