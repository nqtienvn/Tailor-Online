package com.tien.tai.application.dto.mapper.entitytoresponse;

import com.tien.tai.application.dto.response.ProductDTO;
import com.tien.tai.infrastructure.persistence.model.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperEntityToResponse {

    public List<ProductDTO> toProductDTOs(List<ProductEntity> entities) {
        return entities.stream()
                .map(e -> ProductDTO.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .categoryId(e.getCategoryId())
                        .fabricId(e.getFabricId())
                        .basePrice(e.getBasePrice())
                        .description(e.getDescription())
                        .isDeleted(e.getIsDeleted())
                        .status(e.getStatus())
                        .build())
                .collect(Collectors.toList());
    }

}
