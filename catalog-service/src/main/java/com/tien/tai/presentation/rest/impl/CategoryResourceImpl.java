package com.tien.tai.presentation.rest.impl;

import com.tien.common.dto.response.ApiResponse;
import com.tien.tai.application.dto.request.CategoryRequest;
import com.tien.tai.application.dto.response.CategoryResponse;
import com.tien.tai.application.service.command.CategoryCommandService;
import com.tien.tai.presentation.rest.CategoryResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CategoryResourceImpl implements CategoryResource {
    private final CategoryCommandService categoryCommandService;
    @Override
    public ApiResponse<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest) {
        return ApiResponse.<CategoryResponse>builder()
                .code(200)
                .message("create category successfully")
                .result(categoryCommandService.create(categoryRequest))
                .build();
    }

    @Override
    public ApiResponse<CategoryResponse> updateCategory(CategoryRequest categoryRequest) {
        return null;
    }

    @Override
    public ApiResponse<String> deleteCategory(Integer id) {
        return null;
    }
}
