package com.tien.tai.infrastructure.persistence.mapper.impl;

import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.Fabric;
import com.tien.tai.infrastructure.persistence.model.FabricEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FabricMapperImpl implements ToEntityDomain<FabricEntity, Fabric> {
    @Override
    public FabricEntity toEntity(Fabric fabric) {
        return FabricEntity.builder()
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
    public List<Fabric> toDomain(List<FabricEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return List.of();
        }
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Fabric toDomain(FabricEntity fabricEntity) {
        return Fabric.builder()
                .name(fabricEntity.getName())
                .id(fabricEntity.getId())
                .color(fabricEntity.getColor())
                .description(fabricEntity.getDescription())
                .status(fabricEntity.getStatus())
                .imageUrl(fabricEntity.getImageUrl())
                .isDeleted(fabricEntity.getIsDeleted())
                .pricePerMeter(fabricEntity.getPricePerMeter())
                .stockQuantity(fabricEntity.getStockQuantity())
                .build();
    }
}
