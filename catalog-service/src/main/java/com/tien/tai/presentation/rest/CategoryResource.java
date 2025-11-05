package com.tien.tai.presentation.rest;

import com.tien.common.dto.response.ApiResponse;
import com.tien.tai.application.dto.request.CategoryRequest;
import com.tien.tai.application.dto.response.CategoryResponse;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/catalog-service/category")
public interface CategoryResource {
    //admin
    @PostMapping()
    ApiResponse<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest);
    //admin
    @PutMapping("/{id}")
    ApiResponse<CategoryResponse> updateCategory(@RequestBody CategoryRequest categoryRequest, @PathVariable(name = "id") Integer id);
    //admin
    @DeleteMapping("/{id}")
    ApiResponse<String> deleteCategory(@PathVariable(name = "id") Integer id);

}
