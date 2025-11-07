package com.tien.tai.presentation.rest.impl;

import com.tien.common.dto.response.ApiResponse;
import com.tien.common.dto.response.PageDTO;
import com.tien.common.dto.response.PagingResponse;
import com.tien.common.service.ServiceCommandCommon;
import com.tien.common.service.ServiceQueryCommon;
import com.tien.tai.application.dto.request.CategoryRequest;
import com.tien.tai.application.dto.request.CategorySearchRequest;
import com.tien.tai.application.dto.response.CategoryResponse;
import com.tien.tai.presentation.rest.CategoryResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog-service/category")
@RequiredArgsConstructor
public class CategoryResourceImpl implements CategoryResource {
    private final ServiceCommandCommon<CategoryResponse, CategoryRequest, Integer> serviceCommandCommon;
    private final ServiceQueryCommon<PageDTO<CategoryResponse>, CategorySearchRequest> serviceQueryCommon;

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
    public PagingResponse<CategoryResponse> search(CategorySearchRequest request) {
        return PagingResponse.of(this.serviceQueryCommon.search(request));
    }
}
