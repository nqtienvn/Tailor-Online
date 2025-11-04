package com.tien.tai.presentation.rest;

import com.tien.common.dto.response.ApiResponse;
import com.tien.tai.application.dto.request.CategoryCreateRequest;
import com.tien.tai.application.dto.response.CategoryResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/catalog-service/category")
public interface CategoryResource {
    //admin
    @PostMapping()
    ApiResponse<CategoryResponse> createCategory(@RequestBody CategoryCreateRequest categoryCreateRequest);
}
