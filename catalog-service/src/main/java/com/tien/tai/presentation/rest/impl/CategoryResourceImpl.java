package com.tien.tai.presentation.rest.impl;

import com.tien.common.controller.catalogservice.CatalogResourceCommon;
import com.tien.common.dto.response.ApiResponse;
import com.tien.common.service.catalogservice.CatalogServiceCommand;
import com.tien.tai.application.dto.request.CategoryRequest;
import com.tien.tai.application.dto.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog-service/category")
@RequiredArgsConstructor
public class CategoryResourceImpl implements CatalogResourceCommon<CategoryResponse, CategoryRequest, Integer> {
    private final CatalogServiceCommand<CategoryResponse, CategoryRequest, Integer> catalogServiceCommand;

    @Override
    public ApiResponse<CategoryResponse> create(CategoryRequest categoryRequest) {
        return ApiResponse.<CategoryResponse>builder()
                .code(200)
                .message("create category successfully")
                .result(catalogServiceCommand.create(categoryRequest))
                .build();
    }

    @Override
    public ApiResponse<CategoryResponse> update(CategoryRequest categoryRequest, Integer id) {
        return ApiResponse.<CategoryResponse>builder()
                .code(200)
                .message("update category successfully")
                .result(catalogServiceCommand.update(categoryRequest, id))
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        catalogServiceCommand.softDelete(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("delete category successfully")
                .build();
    }

    @Override
    public ApiResponse<String> inActive(Integer id) {
        return null;
    }

    @Override
    public ApiResponse<String> active(Integer id) {
        return null;
    }
}
