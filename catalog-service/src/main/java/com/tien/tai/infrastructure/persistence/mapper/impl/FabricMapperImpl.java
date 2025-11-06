package com.tien.tai.infrastructure.persistence.mapper.impl;

import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.FabricDomain;
import com.tien.tai.infrastructure.persistence.model.Fabric;
import org.springframework.stereotype.Component;

@Component
public class FabricMapperImpl implements ToEntityDomain<Fabric, FabricDomain> {
    @Override
    public Fabric toEntity(FabricDomain fabric) {
        return Fabric.builder()
                .name(fabric.getName())
                .id(fabric.getId())
                .color(fabric.getColor())
                .description(fabric.getDescription())
                .status(fabric.getStatus())
                .imageUrl(fabric.getImageUrl())
                .isDeleted(fabric.getIsDeleted())
                .pricePerMeter(fabric.getPricePerMeter())
                .stockQuantity(fabric.getStockQuantity())
                .build();
    }

    @Override
    public FabricDomain toDomain(Fabric fabric) {
        return FabricDomain.builder()
                .name(fabric.getName())
                .id(fabric.getId())
                .color(fabric.getColor())
                .description(fabric.getDescription())
                .status(fabric.getStatus())
                .imageUrl(fabric.getImageUrl())
                .isDeleted(fabric.getIsDeleted())
                .pricePerMeter(fabric.getPricePerMeter())
                .stockQuantity(fabric.getStockQuantity())
                .build();
    }
}
