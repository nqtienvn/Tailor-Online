package com.tien.tai.presentation.rest.impl;

import com.tien.common.dto.response.ApiResponse;
import com.tien.common.dto.response.PageDTO;
import com.tien.common.dto.response.PagingResponse;
import com.tien.common.service.ServiceCatalogCommandCommon;
import com.tien.common.service.ServiceQueryCommon;
import com.tien.tai.application.dto.request.CategoryRequest;
import com.tien.tai.application.dto.request.CategorySearchRequest;
import com.tien.tai.application.dto.response.CategoryDTO;
import com.tien.tai.infrastructure.persistence.model.CategoryEntity;
import com.tien.tai.infrastructure.persistence.repository.CategoryRepository;
import com.tien.tai.presentation.rest.CategoryResourceCatalog;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/catalog-service/category")
@RequiredArgsConstructor
public class CategoryResourceCatalogImpl implements CategoryResourceCatalog {
    private final ServiceCatalogCommandCommon<CategoryDTO, CategoryRequest, Integer> serviceCatalogCommandCommon;
    private final ServiceQueryCommon<PageDTO<CategoryDTO>, CategorySearchRequest> serviceQueryCommon;
    private final CategoryRepository categoryRepository;

    @Override
    public ApiResponse<CategoryDTO> create(CategoryRequest categoryRequest) {
        return ApiResponse.<CategoryDTO>builder()
                .code(200)
                .message("create category successfully")
                .result(serviceCatalogCommandCommon.create(categoryRequest))
                .build();
    }

    @Override
    public ApiResponse<CategoryDTO> update(CategoryRequest categoryRequest, Integer id) {
        return ApiResponse.<CategoryDTO>builder()
                .code(200)
                .message("update category successfully")
                .result(serviceCatalogCommandCommon.update(categoryRequest, id))
                .build();
    }

    @Override
    public ApiResponse<CategoryDTO> detail(Integer id) {
        return ApiResponse.<CategoryDTO>builder()
                .code(200)
                .message("get category by successfully")
                .result(serviceCatalogCommandCommon.detail(id))
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        serviceCatalogCommandCommon.softDelete(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("delete category successfully")
                .build();
    }

    @Override
    public ApiResponse<String> inActive(Integer id) {
        return null;
    }

    @Override
    public ApiResponse<String> active(Integer id) {
        return null;
    }

    @Override
    public PagingResponse<CategoryDTO> search(CategorySearchRequest request) {
        return PagingResponse.of(this.serviceQueryCommon.search(request));
    }

    @Override
    public ResponseEntity<Resource> export() {
        try {
            List<CategoryEntity> categories = categoryRepository.findAll();

            Context context = new Context();
            context.putVar("categories", categories);

            InputStream template = new ClassPathResource("categorytemplate.xlsx").getInputStream();

            ByteArrayOutputStream output = new ByteArrayOutputStream();

            JxlsHelper.getInstance().processTemplate(template, output, context);

            byte[] excelBytes = output.toByteArray();
            ByteArrayResource resource = new ByteArrayResource(excelBytes);
            template.close();
            output.close();

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=categories.xlsx")
                    .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                    .body(resource);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}
