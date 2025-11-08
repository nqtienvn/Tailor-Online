package com.tien.tai.domain.repository;

import com.tien.common.domain.repository.DomainRepositoryCommon;
import com.tien.tai.application.dto.response.CategoryDTO;
import com.tien.tai.domain.model.Category;

import java.util.List;

public interface CategoryDomainRepository extends DomainRepositoryCommon<Category, Integer> {
    void enrichDTO(List<CategoryDTO> categoryDTOS);
}
