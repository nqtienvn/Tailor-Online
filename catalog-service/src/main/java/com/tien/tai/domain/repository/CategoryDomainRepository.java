package com.tien.tai.domain.repository;

import com.tien.tai.application.dto.response.CategoryResponse;
import com.tien.tai.domain.command.CategoryCreateCmd;

public interface CategoryDomainRepository {
    CategoryResponse createCategory(CategoryCreateCmd categoryCreateCmd);
}
