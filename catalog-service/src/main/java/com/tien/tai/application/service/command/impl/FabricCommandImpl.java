package com.tien.tai.application.service.command.impl;

import com.tien.common.domain.repository.CatalogDomainRepositoryCommon;
import com.tien.common.service.catalogservice.CatalogServiceCommand;
import com.tien.tai.application.dto.mapper.FabricMapperDTO;
import com.tien.tai.application.dto.request.FabricRequest;
import com.tien.tai.application.dto.response.FabricResponse;
import com.tien.tai.application.mapper.FabricCommandMapper;
import com.tien.tai.domain.model.FabricDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FabricCommandImpl implements CatalogServiceCommand<FabricResponse, FabricRequest, Integer> {
    private final FabricCommandMapper fabricCommandMapper;
    private final FabricMapperDTO fabricMapperDTO;
    private final CatalogDomainRepositoryCommon<FabricDomain, Integer> catalogDomainRepositoryCommon;

    @Override
    public FabricResponse create(FabricRequest fabricRequest) {
        FabricDomain fabricCreate = new FabricDomain(fabricCommandMapper.from(fabricRequest));
        return fabricMapperDTO.from(catalogDomainRepositoryCommon.save(fabricCreate));
    }

    @Override
    public FabricResponse update(FabricRequest fabricRequest, Integer id) {
        FabricDomain fabricUpdate = catalogDomainRepositoryCommon.findById(id);
        fabricUpdate.update(fabricCommandMapper.from(fabricRequest));
        return fabricMapperDTO.from(catalogDomainRepositoryCommon.save(fabricUpdate));
    }

    @Override
    public void softDelete(Integer id) {
        FabricDomain fabricDelete = catalogDomainRepositoryCommon.findById(id);
        fabricDelete.softDelete();
        catalogDomainRepositoryCommon.softDelete(fabricDelete);
    }

    @Override
    public void inActive(Integer id) {
        FabricDomain fabricInActive = catalogDomainRepositoryCommon.findById(id);
        fabricInActive.inActive();
        catalogDomainRepositoryCommon.saveStatus(fabricInActive);
    }

    @Override
    public void active(Integer id) {
        FabricDomain fabricActive = catalogDomainRepositoryCommon.findById(id);
        fabricActive.active();
        catalogDomainRepositoryCommon.saveStatus(fabricActive);
    }
}
