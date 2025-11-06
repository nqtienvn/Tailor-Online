package com.tien.tai.presentation.rest.impl;

import com.tien.common.controller.catalogservice.ResourceCommon;
import com.tien.common.dto.response.ApiResponse;
import com.tien.common.service.ServiceCommandCommon;
import com.tien.tai.application.dto.request.ProductRequest;
import com.tien.tai.application.dto.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalog-service/product")
public class ProductResourceImpl implements ResourceCommon<ProductResponse, ProductRequest, Integer> {
    private final ServiceCommandCommon<ProductResponse, ProductRequest, Integer> serviceCommandCommon;

    @Override
    public ApiResponse<ProductResponse> create(ProductRequest productRequest) {
        return ApiResponse.<ProductResponse>builder()
                .code(200)
                .message("add product successfully")
                .result(serviceCommandCommon.create(productRequest))
                .build();
    }

    @Override
    public ApiResponse<ProductResponse> update(ProductRequest productRequest, Integer id) {
        return ApiResponse.<ProductResponse>builder()
                .code(200)
                .message("update product successfully")
                .result(serviceCommandCommon.update(productRequest, id))
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        serviceCommandCommon.softDelete(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("deleted product successfully")
                .build();
    }

    @Override
    public ApiResponse<String> inActive(Integer id) {
        serviceCommandCommon.inActive(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("in active product successfully")
                .build();
    }

    @Override
    public ApiResponse<String> active(Integer id) {
        serviceCommandCommon.active(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("active product successfully")
                .build();
    }
}
