package com.tien.tai.presentation.rest;

import com.tien.common.controller.catalogservice.ResourceCatalogCommon;
import com.tien.common.dto.response.PagingResponse;
import com.tien.tai.application.dto.request.CategoryRequest;
import com.tien.tai.application.dto.request.CategorySearchRequest;
import com.tien.tai.application.dto.response.CategoryDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Tag(name = "category-resource")
public interface CategoryResourceCatalog extends ResourceCatalogCommon<CategoryDTO, CategoryRequest, Integer> {
    @Operation(summary = "filter category",
            description = "filter category by name,....")
    @GetMapping("/filter")
    PagingResponse<CategoryDTO> search(CategorySearchRequest request);

    @Operation(summary = "export EXCEL",
            description = "export excel by JXLS template")
    @PostMapping("/export")
    ResponseEntity<Resource> export() throws IOException;
}
