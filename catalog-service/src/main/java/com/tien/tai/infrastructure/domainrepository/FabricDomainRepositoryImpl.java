package com.tien.tai.infrastructure.domainrepository;

import com.tien.common.domain.repository.DomainRepositoryCommon;
import com.tien.common.exception.AppException;
import com.tien.common.exception.error.NotFoundError;
import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.Fabric;
import com.tien.tai.infrastructure.persistence.model.FabricEntity;
import com.tien.tai.infrastructure.persistence.repository.FabricRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FabricDomainRepositoryImpl implements DomainRepositoryCommon<Fabric, Integer> {
    private final FabricRepository fabricRepository;
    private final ToEntityDomain<FabricEntity, Fabric> toEntityDomain;

    @Override
    public Fabric save(Fabric fabric) {
        FabricEntity savedFabricEntity = fabricRepository.save(toEntityDomain.toEntity(fabric));
        return toEntityDomain.toDomain(savedFabricEntity);
    }

    @Override
    public Fabric findById(Integer id) {
        return toEntityDomain.toDomain(fabricRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(new AppException(NotFoundError.NOT_FOUND))));
    }

    @Override
    public void softDelete(Fabric fabric) {
        fabricRepository.save(toEntityDomain.toEntity(fabric));
    }

    @Override
    public void saveStatus(Fabric fabric) {
        fabricRepository.save(toEntityDomain.toEntity(fabric));
    }
}
