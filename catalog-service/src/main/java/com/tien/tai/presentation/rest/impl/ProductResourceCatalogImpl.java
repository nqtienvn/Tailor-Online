package com.tien.tai.presentation.rest.impl;

import com.tien.common.dto.response.ApiResponse;
import com.tien.common.dto.response.PageDTO;
import com.tien.common.dto.response.PagingResponse;
import com.tien.common.service.ServiceCommandCommon;
import com.tien.common.service.ServiceQueryCommon;
import com.tien.tai.application.dto.request.ProductRequest;
import com.tien.tai.application.dto.request.ProductSearchRequest;
import com.tien.tai.application.dto.response.ProductDTO;
import com.tien.tai.presentation.rest.ProductResourceCatalog;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalog-service/product")
public class ProductResourceCatalogImpl implements ProductResourceCatalog {
    private final ServiceCommandCommon<ProductDTO, ProductRequest, Integer> serviceCommandCommon;
    private final ServiceQueryCommon<PageDTO<ProductDTO>, ProductSearchRequest> serviceQueryCommon;

    @Override
    public ApiResponse<ProductDTO> create(ProductRequest productRequest) {
        return ApiResponse.<ProductDTO>builder()
                .code(200)
                .message("add product successfully")
                .result(serviceCommandCommon.create(productRequest))
                .build();
    }

    @Override
    public ApiResponse<ProductDTO> update(ProductRequest productRequest, Integer id) {
        return ApiResponse.<ProductDTO>builder()
                .code(200)
                .message("update product successfully")
                .result(serviceCommandCommon.update(productRequest, id))
                .build();
    }

    @Override
    public ApiResponse<ProductDTO> detail(Integer id) {
        return ApiResponse.<ProductDTO>builder()
                .code(200)
                .message("get product successfully")
                .result(serviceCommandCommon.detail(id))
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

    @Override
    public PagingResponse<ProductDTO> search(ProductSearchRequest request) {
        return PagingResponse.of(this.serviceQueryCommon.search(request));
    }
}
