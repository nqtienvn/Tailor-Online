package com.tien.tai.presentation.rest.impl;

import com.tien.common.dto.response.ApiResponse;
import com.tien.common.service.ServiceCommandCommon;
import com.tien.common.service.ServiceQueryCommon;
import com.tien.tai.application.dto.request.CategoryRequest;
import com.tien.tai.application.dto.response.CategoryResponse;
import com.tien.tai.presentation.rest.CategoryResource;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog-service/category")
@RequiredArgsConstructor
public class CategoryResourceImpl implements CategoryResource {
    private final ServiceCommandCommon<CategoryResponse, CategoryRequest, Integer> serviceCommandCommon;
    private final ServiceQueryCommon<Page<CategoryResponse>, Integer> serviceQueryCommon;

    @Override
    public ApiResponse<CategoryResponse> create(CategoryRequest categoryRequest) {
        return ApiResponse.<CategoryResponse>builder()
                .code(200)
                .message("create category successfully")
                .result(serviceCommandCommon.create(categoryRequest))
                .build();
    }

    @Override
    public ApiResponse<CategoryResponse> update(CategoryRequest categoryRequest, Integer id) {
        return ApiResponse.<CategoryResponse>builder()
                .code(200)
                .message("update category successfully")
                .result(serviceCommandCommon.update(categoryRequest, id))
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        serviceCommandCommon.softDelete(id);
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

    @Override
    public ApiResponse<Page<CategoryResponse>> create(Integer page, Integer size) {
        return ApiResponse.<Page<CategoryResponse>>builder()
                .code(200)
                .message("update category successfully")
                .result(serviceQueryCommon.getAll(page, size))
                .build();
    }
}
