package com.tien.tai.presentation.rest.impl;

import com.tien.common.dto.response.ApiResponse;
import com.tien.common.dto.response.PageDTO;
import com.tien.common.dto.response.PagingResponse;
import com.tien.common.service.ServiceCatalogCommandCommon;
import com.tien.common.service.ServiceQueryCommon;
import com.tien.tai.application.dto.request.CategoryRequest;
import com.tien.tai.application.dto.request.CategorySearchRequest;
import com.tien.tai.application.dto.response.CategoryDTO;
import com.tien.tai.presentation.rest.CategoryResourceCatalog;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog-service/category")
@RequiredArgsConstructor
public class CategoryResourceCatalogImpl implements CategoryResourceCatalog {
    private final ServiceCatalogCommandCommon<CategoryDTO, CategoryRequest, Integer> serviceCatalogCommandCommon;
    private final ServiceQueryCommon<PageDTO<CategoryDTO>, CategorySearchRequest> serviceQueryCommon;

    @Override
    public ApiResponse<CategoryDTO> create(CategoryRequest categoryRequest) {
        return ApiResponse.<CategoryDTO>builder()
                .code(200)
                .message("create category successfully")
                .result(serviceCatalogCommandCommon.create(categoryRequest))
                .build();
    }

    @Override
    public ApiResponse<CategoryDTO> update(CategoryRequest categoryRequest, Integer id) {
        return ApiResponse.<CategoryDTO>builder()
                .code(200)
                .message("update category successfully")
                .result(serviceCatalogCommandCommon.update(categoryRequest, id))
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        serviceCatalogCommandCommon.softDelete(id);
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
    public PagingResponse<CategoryDTO> search(CategorySearchRequest request) {
        return PagingResponse.of(this.serviceQueryCommon.search(request));
    }
}
