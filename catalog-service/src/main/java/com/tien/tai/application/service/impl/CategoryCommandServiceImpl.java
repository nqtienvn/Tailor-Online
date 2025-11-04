package com.tien.tai.application.service.impl;

import com.tien.tai.application.dto.request.CategoryCreateRequest;
import com.tien.tai.application.dto.response.CategoryResponse;
import com.tien.tai.application.service.command.CategoryCommandService;
import org.springframework.stereotype.Service;

@Service
public class CategoryCommandServiceImpl implements CategoryCommandService {
    @Override
    public CategoryResponse create(CategoryCreateRequest categoryCreateRequest) {

    }
}
