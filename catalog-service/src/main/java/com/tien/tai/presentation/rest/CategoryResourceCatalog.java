package com.tien.tai.presentation.rest;

import com.tien.common.controller.catalogservice.ResourceCatalogCommon;
import com.tien.common.dto.response.PagingResponse;
import com.tien.tai.application.dto.request.CategoryRequest;
import com.tien.tai.application.dto.request.CategorySearchRequest;
import com.tien.tai.application.dto.response.CategoryDTO;
import org.springframework.web.bind.annotation.GetMapping;

public interface CategoryResourceCatalog extends ResourceCatalogCommon<CategoryDTO, CategoryRequest, Integer> {
    @GetMapping("/filter")
    PagingResponse<CategoryDTO> search(CategorySearchRequest request);
}
