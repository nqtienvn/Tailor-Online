package com.tien.tai.application.service.command.impl;

import com.tien.common.domain.repository.DomainRepositoryCommon;
import com.tien.common.service.ServiceCatalogCommandCommon;
import com.tien.tai.application.dto.mapper.FabricMapperDTO;
import com.tien.tai.application.dto.request.FabricRequest;
import com.tien.tai.application.dto.response.FabricDTO;
import com.tien.tai.application.mapper.FabricCommandMapper;
import com.tien.tai.domain.model.Fabric;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FabricCommandServiceCatalogImpl implements ServiceCatalogCommandCommon<FabricDTO, FabricRequest, Integer> {
    private final FabricCommandMapper fabricCommandMapper;
    private final FabricMapperDTO fabricMapperDTO;
    private final DomainRepositoryCommon<Fabric, Integer> domainRepositoryCommon;

    @Override
    public FabricDTO create(FabricRequest fabricRequest) {
        Fabric fabricCreate = new Fabric(fabricCommandMapper.from(fabricRequest));
        return fabricMapperDTO.from(domainRepositoryCommon.save(fabricCreate));
    }

    @Override
    public FabricDTO update(FabricRequest fabricRequest, Integer id) {
        Fabric fabricUpdate = domainRepositoryCommon.findById(id);
        fabricUpdate.update(fabricCommandMapper.from(fabricRequest));
        return fabricMapperDTO.from(domainRepositoryCommon.save(fabricUpdate));
    }

    @Override
    public FabricDTO detail(Integer id) {
        return fabricMapperDTO.from(domainRepositoryCommon.findById(id));
    }

    @Override
    public void softDelete(Integer id) {
        Fabric fabricDelete = domainRepositoryCommon.findById(id);
        fabricDelete.softDelete();
        domainRepositoryCommon.softDelete(fabricDelete);
    }

    @Override
    public void inActive(Integer id) {
        Fabric fabricInActive = domainRepositoryCommon.findById(id);
        fabricInActive.inActive();
        domainRepositoryCommon.saveStatus(fabricInActive);
    }

    @Override
    public void active(Integer id) {
        Fabric fabricActive = domainRepositoryCommon.findById(id);
        fabricActive.active();
        domainRepositoryCommon.saveStatus(fabricActive);
    }
}
