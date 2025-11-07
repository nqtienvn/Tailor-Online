package com.tien.tai.application.dto.mapper.entitytoresponse;

import com.tien.tai.application.dto.response.CategoryResponse;
import com.tien.tai.application.dto.response.ProductResponse;
import com.tien.tai.infrastructure.persistence.model.CategoryEntity;
import com.tien.tai.infrastructure.persistence.model.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperEntityToResponse {
    public List<CategoryResponse> toResponse(List<CategoryEntity> entities) {
        return entities.stream()
                .map(e -> CategoryResponse.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .isDeleted((e.getIsDeleted()))
                        .build())
                .collect(Collectors.toList());
    }

    public List<ProductResponse> toProductDTOs(List<ProductEntity> entities) {
        return entities.stream()
                .map(e -> ProductResponse.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .categoryId(e.getCategoryId())
                        .build())
                .collect(Collectors.toList());
    }

}
