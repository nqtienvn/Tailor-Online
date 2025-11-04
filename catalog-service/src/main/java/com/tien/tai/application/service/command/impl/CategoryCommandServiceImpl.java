package com.tien.tai.application.service.command.impl;

import com.tien.tai.application.dto.mapper.CategoryMapperDTO;
import com.tien.tai.application.dto.request.CategoryCreateRequest;
import com.tien.tai.application.dto.response.CategoryResponse;
import com.tien.tai.application.mapper.CategoryCommandMapper;
import com.tien.tai.application.service.command.CategoryCommandService;
import com.tien.tai.domain.command.CategoryCreateCmd;
import com.tien.tai.domain.model.CategoryDomain;
import com.tien.tai.domain.service.CategoryFactory;
import com.tien.tai.domain.repository.CategoryDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryCommandServiceImpl implements CategoryCommandService {
    private final CategoryCommandMapper categoryCommandMapper;
    private final CategoryDomainRepository categoryDomainRepository;
    private final CategoryMapperDTO categoryMapperDTO;
    private final CategoryFactory categoryFactory;
    @Override
    public CategoryResponse create(CategoryCreateRequest categoryCreateRequest) {
        //mapper tu request sang thang cmd
        CategoryCreateCmd categoryCreateCmd = categoryCommandMapper.from(categoryCreateRequest);
        CategoryDomain domainCategory = categoryFactory.create(categoryCreateCmd);
        CategoryDomain savedDomainCategory = categoryDomainRepository.save(domainCategory);
        return categoryMapperDTO.from(savedDomainCategory);
        //xong ty nua lai mapper nguoc lai bang thang mapper trong DTO dẻ trả ra response, LÁY CATEGORY TRONG ĐÚNG THẰNG DOMAIN
    }
}
