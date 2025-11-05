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
        //mapper tu request sang thang cmd
        CategoryCmd categoryCmd = categoryCommandMapper.from(categoryRequest);
        CategoryDomain domainCategory = CategoryDomain.create(categoryCmd);
        CategoryDomain savedDomainCategory = categoryDomainRepository.save(domainCategory);
        return categoryMapperDTO.from(savedDomainCategory);
        //xong ty nua lai mapper nguoc lai bang thang mapper trong DTO dẻ trả ra response, LÁY CATEGORY TRONG ĐÚNG THẰNG DOMAIN
    }
}
