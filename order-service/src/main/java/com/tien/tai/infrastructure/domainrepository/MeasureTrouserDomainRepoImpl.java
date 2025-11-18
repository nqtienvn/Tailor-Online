package com.tien.tai.infrastructure.domainrepository;

import com.tien.common.exception.AppException;
import com.tien.common.exception.error.NotFoundError;
import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.MeasurementTrouserDomain;
import com.tien.tai.domain.repository.MeasurementTrouserDomainRepo;
import com.tien.tai.infrastructure.persistence.model.MeasurementTrouserEntity;
import com.tien.tai.infrastructure.persistence.repository.MeasurementTrouserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MeasureTrouserDomainRepoImpl implements MeasurementTrouserDomainRepo {
    private final ToEntityDomain<MeasurementTrouserEntity, MeasurementTrouserDomain> toEntityDomain;
    private final MeasurementTrouserRepository measurementTrouserRepository;

    @Override
    public MeasurementTrouserDomain save(MeasurementTrouserDomain domain) {
        return toEntityDomain.toDomain(measurementTrouserRepository.save(toEntityDomain.toEntity(domain)));
    }

    @Override
    public MeasurementTrouserDomain findById(Integer id) {
        return toEntityDomain.toDomain(measurementTrouserRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException(new AppException(NotFoundError.NOT_FOUND))));
    }

    @Override
    public void softDelete(MeasurementTrouserDomain domain) {
        measurementTrouserRepository.save(toEntityDomain.toEntity(domain));
    }

    @Override
    public void saveStatus(MeasurementTrouserDomain domain) {
        measurementTrouserRepository.save(toEntityDomain.toEntity(domain));
    }
}
