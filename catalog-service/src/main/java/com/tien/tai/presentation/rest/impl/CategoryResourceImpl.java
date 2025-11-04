package com.tien.tai.presentation.rest.impl;

import com.tien.common.dto.response.ApiResponse;
import com.tien.tai.application.dto.request.CategoryCreateRequest;
import com.tien.tai.application.dto.response.CategoryResponse;
import com.tien.tai.presentation.rest.CategoryResource;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryResourceImpl implements CategoryResource {

    @Override
    public ApiResponse<CategoryResponse> createCategory(CategoryCreateRequest categoryCreateRequest) {
        return ApiResponse.<CategoryResponse>builder()
                .code(200)
                .message("create category successfully")
                .result()
                .build();
    }
}
