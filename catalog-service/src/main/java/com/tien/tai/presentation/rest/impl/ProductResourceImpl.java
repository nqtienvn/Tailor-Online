package com.tien.tai.presentation.rest.impl;

import com.tien.common.controller.catalogservice.CatalogResourceCommon;
import com.tien.common.dto.response.ApiResponse;
import com.tien.common.service.catalogservice.ServiceCatalogCommon;
import com.tien.tai.application.dto.request.ProductRequest;
import com.tien.tai.application.dto.response.ProductResponse;
import com.tien.tai.application.service.command.impl.ProductCommandServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalog-service/product")
public class ProductResourceImpl implements CatalogResourceCommon<ProductResponse, ProductRequest, Integer> {
    private final ServiceCatalogCommon<ProductResponse, ProductRequest, Integer> serviceCatalogCommon;

    @Override
    public ApiResponse<ProductResponse> create(ProductRequest productRequest) {
        return ApiResponse.<ProductResponse>builder()
                .code(200)
                .message("add product successfully")
                .result(serviceCatalogCommon.create(productRequest))
                .build();
    }

    @Override
    public ApiResponse<ProductResponse> update(ProductRequest productRequest, Integer id) {
        return ApiResponse.<ProductResponse>builder()
                .code(200)
                .message("update product successfully")
                .result(serviceCatalogCommon.update(productRequest, id))
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        serviceCatalogCommon.softDelete(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("deleted product successfully")
                .build();
    }

    @Override
    public ApiResponse<String> inActive(Integer id) {
        serviceCatalogCommon.inActive(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("in active product successfully")
                .build();
    }

    @Override
    public ApiResponse<String> active(Integer id) {
        serviceCatalogCommon.active(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("active product successfully")
                .build();
    }
}
