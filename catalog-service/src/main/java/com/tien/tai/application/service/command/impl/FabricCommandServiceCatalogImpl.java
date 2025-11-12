package com.tien.tai.application.service.command.impl;

import com.tien.common.domain.repository.DomainRepositoryCommon;
import com.tien.common.service.ServiceCatalogCommandCommon;
import com.tien.tai.application.dto.mapper.FabricMapperDTO;
import com.tien.tai.application.dto.request.FabricRequest;
import com.tien.tai.application.dto.response.CategoryDTO;
import com.tien.tai.application.dto.response.FabricDTO;
import com.tien.tai.application.mapper.FabricCommandMapper;
import com.tien.tai.domain.model.Category;
import com.tien.tai.domain.model.Fabric;
import com.tien.tai.domain.repository.FabricDomainRepository;
import com.tien.tai.infrastructure.domainrepository.FabricDomainRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FabricCommandServiceCatalogImpl implements ServiceCatalogCommandCommon<FabricDTO, FabricRequest, Integer> {
    private final FabricCommandMapper fabricCommandMapper;
    private final FabricMapperDTO fabricMapperDTO;
    private final FabricDomainRepository fabricDomainRepository;

    @Override
    public FabricDTO create(FabricRequest fabricRequest) {
        Fabric fabricCreate = new Fabric(fabricCommandMapper.from(fabricRequest));
        return fabricMapperDTO.from(fabricDomainRepository.save(fabricCreate));
    }

    @Override
    public FabricDTO update(FabricRequest fabricRequest, Integer id) {
        Fabric fabricUpdate = fabricDomainRepository.findById(id);
        fabricUpdate.update(fabricCommandMapper.from(fabricRequest));
        return fabricMapperDTO.from(fabricDomainRepository.save(fabricUpdate));
    }

    @Override
    public FabricDTO detail(Integer id) {
        Fabric fabricDetail = fabricDomainRepository.findById(id);
        FabricDTO fabricDTO = fabricMapperDTO.from(fabricDetail);
        fabricDomainRepository.enrichDTO(List.of(fabricDTO));
        return fabricDTO;
    }

    @Override
    public void softDelete(Integer id) {
        Fabric fabricDelete = fabricDomainRepository.findById(id);
        fabricDelete.softDelete();
        fabricDomainRepository.softDelete(fabricDelete);
    }

    @Override
    public void inActive(Integer id) {
        Fabric fabricInActive = fabricDomainRepository.findById(id);
        fabricInActive.inActive();
        fabricDomainRepository.saveStatus(fabricInActive);
    }

    @Override
    public void active(Integer id) {
        Fabric fabricActive = fabricDomainRepository.findById(id);
        fabricActive.active();
        fabricDomainRepository.saveStatus(fabricActive);
    }
}
