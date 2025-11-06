package com.tien.tai.application.service.command.impl;

import com.tien.common.domain.repository.DomainRepositoryCommon;
import com.tien.common.service.ServiceCommandCommon;
import com.tien.tai.application.dto.mapper.FabricMapperDTO;
import com.tien.tai.application.dto.request.FabricRequest;
import com.tien.tai.application.dto.response.FabricResponse;
import com.tien.tai.application.mapper.FabricCommandMapper;
import com.tien.tai.domain.model.FabricDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FabricCommandImpl implements ServiceCommandCommon<FabricResponse, FabricRequest, Integer> {
    private final FabricCommandMapper fabricCommandMapper;
    private final FabricMapperDTO fabricMapperDTO;
    private final DomainRepositoryCommon<FabricDomain, Integer> domainRepositoryCommon;

    @Override
    public FabricResponse create(FabricRequest fabricRequest) {
        FabricDomain fabricCreate = new FabricDomain(fabricCommandMapper.from(fabricRequest));
        return fabricMapperDTO.from(domainRepositoryCommon.save(fabricCreate));
    }

    @Override
    public FabricResponse update(FabricRequest fabricRequest, Integer id) {
        FabricDomain fabricUpdate = domainRepositoryCommon.findById(id);
        fabricUpdate.update(fabricCommandMapper.from(fabricRequest));
        return fabricMapperDTO.from(domainRepositoryCommon.save(fabricUpdate));
    }

    @Override
    public void softDelete(Integer id) {
        FabricDomain fabricDelete = domainRepositoryCommon.findById(id);
        fabricDelete.softDelete();
        domainRepositoryCommon.softDelete(fabricDelete);
    }

    @Override
    public void inActive(Integer id) {
        FabricDomain fabricInActive = domainRepositoryCommon.findById(id);
        fabricInActive.inActive();
        domainRepositoryCommon.saveStatus(fabricInActive);
    }

    @Override
    public void active(Integer id) {
        FabricDomain fabricActive = domainRepositoryCommon.findById(id);
        fabricActive.active();
        domainRepositoryCommon.saveStatus(fabricActive);
    }
}
