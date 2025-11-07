package com.tien.tai.presentation.rest;

import com.tien.common.controller.catalogservice.ResourceCommon;
import com.tien.common.dto.response.PagingResponse;
import com.tien.tai.application.dto.request.ProductRequest;
import com.tien.tai.application.dto.request.ProductSearchRequest;
import com.tien.tai.application.dto.response.ProductResponse;
import org.springframework.web.bind.annotation.GetMapping;

public interface ProductResource extends ResourceCommon<ProductResponse, ProductRequest, Integer> {
    @GetMapping("/filter")
    PagingResponse<ProductResponse> search(ProductSearchRequest request);
}
