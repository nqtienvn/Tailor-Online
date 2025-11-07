package com.tien.tai.presentation.rest;

import com.tien.common.controller.catalogservice.ResourceCommon;
import com.tien.common.dto.response.PagingResponse;
import com.tien.tai.application.dto.request.CategoryRequest;
import com.tien.tai.application.dto.request.CategorySearchRequest;
import com.tien.tai.application.dto.response.CategoryResponse;
import org.springframework.web.bind.annotation.GetMapping;

public interface CategoryResource extends ResourceCommon<CategoryResponse, CategoryRequest, Integer> {
    @GetMapping("/filter")
    PagingResponse<CategoryResponse> search(CategorySearchRequest request);
}
