package com.tien.tai.infrastructure.domainrepository;

import com.tien.common.exception.AppException;
import com.tien.common.exception.error.NotFoundError;
import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.MeasurementShirtDomain;
import com.tien.tai.domain.repository.MeasurementShirtDomainRepo;
import com.tien.tai.infrastructure.persistence.model.MeasurementShirtEntity;
import com.tien.tai.infrastructure.persistence.repository.MeasurementShirtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MeasureShirtDomainRepoImpl implements MeasurementShirtDomainRepo {
    private final ToEntityDomain<MeasurementShirtEntity, MeasurementShirtDomain> toEntityDomain;
    private final MeasurementShirtRepository measurementShirtRepository;

    @Override
    public MeasurementShirtDomain save(MeasurementShirtDomain domain) {
        return toEntityDomain.toDomain(measurementShirtRepository.save(toEntityDomain.toEntity(domain)));
    }

    @Override
    public MeasurementShirtDomain findById(Integer id) {
        return toEntityDomain.toDomain(measurementShirtRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException(new AppException(NotFoundError.NOT_FOUND))));
    }

    @Override
    public void softDelete(MeasurementShirtDomain domain) {
        measurementShirtRepository.save(toEntityDomain.toEntity(domain));
    }

    @Override
    public void saveStatus(MeasurementShirtDomain domain) {
        measurementShirtRepository.save(toEntityDomain.toEntity(domain));
    }
}
