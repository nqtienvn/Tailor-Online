package com.tien.tai.application.service.command.impl;

import com.tien.common.service.ServiceCatalogCommandCommon;
import com.tien.tai.application.dto.mapper.MeasurementMapperDTO;
import com.tien.tai.application.dto.request.MeasurementRequest;
import com.tien.tai.application.dto.response.MeasurementDTO;
import com.tien.tai.application.mapper.MeasurementCommandMapper;
import com.tien.tai.domain.command.MeasurementCmd;
import com.tien.tai.domain.model.MeasurementDomain;
import com.tien.tai.domain.repository.MeasurementDomainRepository;
import com.tien.tai.infrastructure.persistence.repository.MeasurementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeasurementCommandServiceCatalogImpl implements ServiceCatalogCommandCommon <MeasurementDTO , MeasurementRequest ,Integer> {
    private final MeasurementCommandMapper commandMapper;
    private final MeasurementMapperDTO mapperDTO;
    private final MeasurementDomainRepository domainRepository;

    @Override
    public MeasurementDTO create(MeasurementRequest request) {
        MeasurementDomain measurementDomain = new MeasurementDomain(commandMapper.form(request));
        return mapperDTO.from(domainRepository.save(measurementDomain));
    }

    @Override
    public MeasurementDTO update(MeasurementRequest request, Integer id) {
        MeasurementCmd measurementCmd = commandMapper.form(request);
        MeasurementDomain measurementDomain = domainRepository.findById(id);
        measurementDomain.update(measurementCmd);
        return mapperDTO.from(domainRepository.save(measurementDomain));
    }

    @Override
    public MeasurementDTO detail(Integer id) {
        return mapperDTO.from(domainRepository.findById(id));
    }

    @Override
    public void softDelete(Integer id) {
        MeasurementDomain findByID = domainRepository.findById(id);
        findByID.softDelete();
        domainRepository.softDelete(findByID);
    }

    @Override
    public void inActive(Integer id) {
        MeasurementDomain findByID = domainRepository.findById(id);
        findByID.inActivate();
        domainRepository.save(findByID);
    }

    @Override
    public void active(Integer id) {
        MeasurementDomain findByID = domainRepository.findById(id);
        findByID.activate();
        domainRepository.save(findByID);
    }
}
