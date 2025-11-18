package com.tien.tai.infrastructure.persistence.mapper.impl;

import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.MeasurementTrouserDomain;
import com.tien.tai.infrastructure.persistence.model.MeasurementTrouserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MeasurementTrouserMapperImpl implements ToEntityDomain<MeasurementTrouserEntity, MeasurementTrouserDomain> {
    @Override
    public MeasurementTrouserEntity toEntity(MeasurementTrouserDomain domain) {
        if (domain == null) return null;

        return MeasurementTrouserEntity.builder()
                .id(domain.getId())
                .trouserLength(domain.getTrouserLength())
                .waist(domain.getWaist())
                .hips(domain.getHips())
                .knee(domain.getKnee())
                .legWidth(domain.getLegWidth())
                .status(domain.getStatus())
                .isDeleted(domain.getIsDeleted())
                .build();
    }

    @Override
    public List<MeasurementTrouserDomain> toDomain(List<MeasurementTrouserEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return List.of();
        }
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public MeasurementTrouserDomain toDomain(MeasurementTrouserEntity entity) {
        if (entity == null) return null;
        return MeasurementTrouserDomain.builder()
                .id(entity.getId())
                .trouserLength(entity.getTrouserLength())
                .waist(entity.getWaist())
                .hips(entity.getHips())
                .knee(entity.getKnee())
                .legWidth(entity.getLegWidth())
                .status(entity.getStatus())
                .isDeleted(entity.getIsDeleted())
                .build();
    }
}
