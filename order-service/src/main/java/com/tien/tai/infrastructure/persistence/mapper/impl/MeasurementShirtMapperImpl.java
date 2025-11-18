package com.tien.tai.infrastructure.persistence.mapper.impl;

import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.MeasurementShirtDomain;
import com.tien.tai.infrastructure.persistence.model.MeasurementShirtEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MeasurementShirtMapperImpl implements ToEntityDomain<MeasurementShirtEntity, MeasurementShirtDomain> {
    @Override
    public MeasurementShirtEntity toEntity(MeasurementShirtDomain domain) {
        return MeasurementShirtEntity.builder()
                .id(domain.getId())
                .chest(domain.getChest())
                .shoulder(domain.getShoulder())
                .sleeveLength(domain.getSleeveLength())
                .armhole(domain.getArmhole())
                .bicep(domain.getBicep())
                .neck(domain.getNeck())
                .shirtLength(domain.getShirtLength())
                .status(domain.getStatus())
                .isDeleted(domain.getIsDeleted())
                .build();
    }

    @Override
    public List<MeasurementShirtDomain> toDomain(List<MeasurementShirtEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return List.of();
        }
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public MeasurementShirtDomain toDomain(MeasurementShirtEntity entity) {
        return MeasurementShirtDomain.builder()
                .id(entity.getId())
                .chest(entity.getChest())
                .shoulder(entity.getShoulder())
                .sleeveLength(entity.getSleeveLength())
                .armhole(entity.getArmhole())
                .bicep(entity.getBicep())
                .neck(entity.getNeck())
                .shirtLength(entity.getShirtLength())
                .status(entity.getStatus())
                .isDeleted(entity.getIsDeleted())
                .build();
    }
}
