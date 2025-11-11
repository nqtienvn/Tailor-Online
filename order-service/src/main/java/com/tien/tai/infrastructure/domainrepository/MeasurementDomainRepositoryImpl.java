package com.tien.tai.infrastructure.domainrepository;

import com.tien.common.exception.AppException;
import com.tien.common.exception.error.NotFoundError;
import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.MeasurementDomain;
import com.tien.tai.domain.repository.MeasurementDomainRepository;
import com.tien.tai.infrastructure.persistence.model.MeasurementEntity;
import com.tien.tai.infrastructure.persistence.repository.MeasurementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MeasurementDomainRepositoryImpl implements MeasurementDomainRepository {
    private final MeasurementRepository measurementRepository;
    private final ToEntityDomain <MeasurementEntity,MeasurementDomain> toEntityDomain;


    @Override
    public MeasurementDomain save(MeasurementDomain domain) {
        return toEntityDomain.toDomain(measurementRepository.save(toEntityDomain.toEntity(domain)));
    }

    @Override
    public MeasurementDomain findById(Integer id) {
        return toEntityDomain.toDomain(measurementRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException(new AppException(NotFoundError.NOT_FOUND)))
        );
    }

    @Override
    public void softDelete(MeasurementDomain domain) {
        measurementRepository.save(toEntityDomain.toEntity(domain));
    }

    @Override
    public void saveStatus(MeasurementDomain domain) {
        measurementRepository.save(toEntityDomain.toEntity(domain));
    }
}
