package com.tien.tai.application.service.command;

import com.tien.tai.application.dto.request.CategoryRequest;
import com.tien.tai.application.dto.response.CategoryResponse;

public interface CategoryCommandService {
    CategoryResponse create(CategoryRequest categoryRequest);
    CategoryResponse update(CategoryRequest categoryRequest, Integer id);
    void softDelete(Integer id);
}
