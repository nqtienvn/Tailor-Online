package com.tien.tai.infrastructure.domainrepository;

import com.tien.tai.application.dto.response.CategoryResponse;
import com.tien.tai.domain.command.CategoryCreateCmd;
import com.tien.tai.domain.repository.CategoryDomainRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDomainRepositoryImpl implements CategoryDomainRepository {
    @Override
    public CategoryResponse createCategory(CategoryCreateCmd categoryCreateCmd) {
        return null;
    }
}
