package com.tien.tai.application.service.command.impl;

import com.tien.tai.application.dto.mapper.FabricMapperDTO;
import com.tien.tai.application.dto.request.FabricRequest;
import com.tien.tai.application.dto.response.FabricResponse;
import com.tien.tai.application.mapper.FabricCommandMapper;
import com.tien.tai.application.service.command.FabricCommandService;
import com.tien.tai.domain.model.FabricDomain;
import com.tien.tai.domain.repository.FabricDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FabricCommandServiceImpl implements FabricCommandService {
    private final FabricCommandMapper fabricCommandMapper;
    private final FabricMapperDTO fabricMapperDTO;
    private final FabricDomainRepository fabricDomainRepository;

    @Override
    public FabricResponse create(FabricRequest fabricRequest) {
        FabricDomain fabricCreate = new FabricDomain(fabricCommandMapper.from(fabricRequest));
        return fabricMapperDTO.from(fabricDomainRepository.save(fabricCreate));
    }

    @Override
    public FabricResponse update(FabricRequest fabricRequest, Integer id) {
        FabricDomain fabricUpdate = fabricDomainRepository.findById(id);
        fabricUpdate.update(fabricCommandMapper.from(fabricRequest));
        return fabricMapperDTO.from(fabricDomainRepository.save(fabricUpdate));
    }

    @Override
    public void softDelete(Integer id) {
        FabricDomain fabricDelete = fabricDomainRepository.findById(id);
        fabricDelete.softDelete();
        fabricDomainRepository.softDelete(fabricDelete);
    }

    @Override
    public void inActive(Integer id) {
        FabricDomain fabricInActive = fabricDomainRepository.findById(id);
        fabricInActive.inActive();
        fabricDomainRepository.saveStatus(fabricInActive);
    }

    @Override
    public void active(Integer id) {
        FabricDomain fabricActive = fabricDomainRepository.findById(id);
        fabricActive.active();
        fabricDomainRepository.saveStatus(fabricActive);
    }
}
