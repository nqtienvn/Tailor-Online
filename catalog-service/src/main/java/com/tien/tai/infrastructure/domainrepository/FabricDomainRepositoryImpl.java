package com.tien.tai.infrastructure.domainrepository;

import com.tien.tai.domain.model.FabricDomain;
import com.tien.tai.domain.repository.FabricDomainRepository;
import com.tien.tai.infrastructure.persistence.mapper.FabricMapper;
import com.tien.tai.infrastructure.persistence.model.Fabric;
import com.tien.tai.infrastructure.persistence.repository.FabricRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FabricDomainRepositoryImpl implements FabricDomainRepository {
    private final FabricRepository fabricRepository;
    private final FabricMapper fabricMapper;

    @Override
    public FabricDomain save(FabricDomain fabricDomain) {
        Fabric savedFabric = fabricRepository.save(fabricMapper.toEntity(fabricDomain));
        return fabricMapper.toDomain(savedFabric);
    }

    @Override
    public FabricDomain findById(Integer id) {
        return fabricMapper.toDomain(fabricRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found fabric")));
    }

    @Override
    public void softDelete(FabricDomain fabricDomain) {
        fabricRepository.save(fabricMapper.toEntity(fabricDomain));
    }

    @Override
    public void saveStatus(FabricDomain fabricDomain) {
        fabricRepository.save(fabricMapper.toEntity(fabricDomain));
    }
}
