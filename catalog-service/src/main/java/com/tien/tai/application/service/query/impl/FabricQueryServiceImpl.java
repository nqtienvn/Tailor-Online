package com.tien.tai.application.service.query.impl;

import com.tien.common.dto.response.PageDTO;
import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.common.service.ServiceQueryCommon;
import com.tien.tai.application.dto.mapper.FabricMapperDTO;
import com.tien.tai.application.dto.request.FabricSearchRequest;
import com.tien.tai.application.dto.response.FabricDTO;
import com.tien.tai.application.mapper.AutoMapperQuery;
import com.tien.tai.domain.model.Fabric;
import com.tien.tai.domain.query.FabricSearchQuery;
import com.tien.tai.domain.repository.FabricDomainRepository;
import com.tien.tai.infrastructure.persistence.model.FabricEntity;
import com.tien.tai.infrastructure.persistence.repository.FabricRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FabricQueryServiceImpl implements ServiceQueryCommon<PageDTO<FabricDTO>, FabricSearchRequest> {
    private final AutoMapperQuery autoMapperQuery;
    private final ToEntityDomain<FabricEntity, Fabric> toEntityDomain;
    private final FabricRepositoryCustom fabricRepositoryCustom;
    private final FabricMapperDTO fabricMapperDTO;
    private final FabricDomainRepository fabricDomainRepository;

    @Override
    public PageDTO<FabricDTO> search(FabricSearchRequest request) {
        FabricSearchQuery fabricQuery = this.autoMapperQuery.from(request);
        Long total = this.fabricRepositoryCustom.count(fabricQuery);
        if (Objects.equals(total, 0L)) {
            return PageDTO.empty();
        }
        List<Fabric> fabrics = this.toEntityDomain.toDomain(this.fabricRepositoryCustom.search(fabricQuery));
        List<FabricDTO> fabricDTOS = this.fabricMapperDTO.toDTO(fabrics);
        this.fabricDomainRepository.enrichDTO(fabricDTOS);
        return new PageDTO<>(fabricDTOS, request.getPageIndex(), request.getPageSize(), total);
    }
}
