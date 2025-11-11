package com.tien.tai.infrastructure.persistence.mapper.impl;

import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.MeasurementDomain;
import com.tien.tai.infrastructure.persistence.model.MeasurementEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class MeasurementMapperImpl implements ToEntityDomain<MeasurementEntity, MeasurementDomain> {
    @Override
    public MeasurementEntity toEntity(MeasurementDomain domain) {
        return MeasurementEntity.builder()
                .id(domain.getId())
                .chest(domain.getChest())
                .waist(domain.getWaist())
                .hips(domain.getHips())
                .shoulder(domain.getShoulder())
                .sleeveLength(domain.getSleeveLength())
                .trouserLength(domain.getTrouserLength())
                .orderId(domain.getOrderID())
                .isDeleted(domain.getIsDeleted())
                .build();
    }

    @Override
    public List<MeasurementDomain> toDomain(List<MeasurementEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return List.of();
        }
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());

    }

    @Override
    public MeasurementDomain toDomain(MeasurementEntity entity) {
        return MeasurementDomain.builder()
                .id(entity.getId())
                .chest(entity.getChest())
                .waist(entity.getWaist())
                .hips(entity.getHips())
                .shoulder(entity.getShoulder())
                .sleeveLength(entity.getSleeveLength())
                .trouserLength(entity.getTrouserLength())
                .orderID(entity.getOrderId())
                .status(entity.getStatus())
                .isDeleted(entity.getIsDeleted())
                .build();
    }
}
