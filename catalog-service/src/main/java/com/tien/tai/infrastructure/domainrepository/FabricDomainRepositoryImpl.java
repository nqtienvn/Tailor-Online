package com.tien.tai.infrastructure.domainrepository;

import com.tien.common.domain.repository.DomainRepositoryCommon;
import com.tien.common.exception.AppException;
import com.tien.common.exception.error.NotFoundError;
import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.FabricDomain;
import com.tien.tai.infrastructure.persistence.model.Fabric;
import com.tien.tai.infrastructure.persistence.repository.FabricRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FabricDomainRepositoryImpl implements DomainRepositoryCommon<FabricDomain, Integer> {
    private final FabricRepository fabricRepository;
    private final ToEntityDomain<Fabric, FabricDomain> toEntityDomain;

    @Override
    public FabricDomain save(FabricDomain fabricDomain) {
        Fabric savedFabric = fabricRepository.save(toEntityDomain.toEntity(fabricDomain));
        return toEntityDomain.toDomain(savedFabric);
    }

    @Override
    public FabricDomain findById(Integer id) {
        return toEntityDomain.toDomain(fabricRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(new AppException(NotFoundError.NOT_FOUND))));
    }

    @Override
    public void softDelete(FabricDomain fabricDomain) {
        fabricRepository.save(toEntityDomain.toEntity(fabricDomain));
    }

    @Override
    public void saveStatus(FabricDomain fabricDomain) {
        fabricRepository.save(toEntityDomain.toEntity(fabricDomain));
    }
}
