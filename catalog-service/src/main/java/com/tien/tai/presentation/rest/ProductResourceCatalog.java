package com.tien.tai.presentation.rest;

import com.tien.common.controller.catalogservice.ResourceCatalogCommon;
import com.tien.common.dto.response.PagingResponse;
import com.tien.tai.application.dto.request.ProductRequest;
import com.tien.tai.application.dto.request.ProductSearchRequest;
import com.tien.tai.application.dto.response.ProductDTO;
import org.springframework.web.bind.annotation.GetMapping;

public interface ProductResourceCatalog extends ResourceCatalogCommon<ProductDTO, ProductRequest, Integer> {
    @GetMapping("/filter")
    PagingResponse<ProductDTO> search(ProductSearchRequest request);
}
