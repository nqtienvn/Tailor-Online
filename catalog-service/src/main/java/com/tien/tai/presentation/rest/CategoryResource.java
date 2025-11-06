package com.tien.tai.presentation.rest;

import com.tien.common.controller.catalogservice.ResourceCommon;
import com.tien.common.dto.response.ApiResponse;
import com.tien.tai.application.dto.request.CategoryRequest;
import com.tien.tai.application.dto.response.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface CategoryResource extends ResourceCommon<CategoryResponse, CategoryRequest, Integer> {
    @PostMapping()
    ApiResponse<Page<CategoryResponse>> create(@RequestParam(defaultValue = "0") Integer page,
                                               @RequestParam(defaultValue = "5") Integer size);
}
