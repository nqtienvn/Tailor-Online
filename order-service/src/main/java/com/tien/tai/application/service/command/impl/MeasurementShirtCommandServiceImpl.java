package com.tien.tai.application.service.command.impl;

import com.tien.tai.application.dto.mapper.MeasurementMapperDTO;
import com.tien.tai.application.dto.request.MeasurementShirtRequest;
import com.tien.tai.application.dto.response.MeasurementShirtDTO;
import com.tien.tai.application.mapper.MeasurementCommandMapper;
import com.tien.tai.application.service.MeasurementShirtCommandService;
import com.tien.tai.domain.command.MeasurementShirtCmd;
import com.tien.tai.domain.model.MeasurementShirtDomain;
import com.tien.tai.domain.repository.MeasurementShirtDomainRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeasurementShirtCommandServiceImpl implements MeasurementShirtCommandService {
    private final MeasurementCommandMapper commandMapper;
    private final MeasurementMapperDTO mapperDTO;
    private final MeasurementShirtDomainRepo domainRepository;

    @Override
    public MeasurementShirtDTO create(MeasurementShirtRequest request) {
        MeasurementShirtCmd cmd = commandMapper.form(request);
        MeasurementShirtDomain measurementShirtDomain = new MeasurementShirtDomain(cmd);
        return mapperDTO.from(domainRepository.save(measurementShirtDomain));
    }

    @Override
    public MeasurementShirtDTO update(MeasurementShirtRequest request, Integer id) {
        MeasurementShirtCmd measurementCmd = commandMapper.form(request);
        MeasurementShirtDomain measurementShirtDomain = domainRepository.findById(id);
        measurementShirtDomain.update(measurementCmd);
        return mapperDTO.from(domainRepository.save(measurementShirtDomain));
    }

    @Override
    public MeasurementShirtDTO detail(Integer id) {
        return mapperDTO.from(domainRepository.findById(id));
    }

    @Override
    public void softDelete(Integer id) {
        MeasurementShirtDomain findByID = domainRepository.findById(id);
        findByID.softDelete();
        domainRepository.softDelete(findByID);
    }

    @Override
    public void inActive(Integer id) {
        MeasurementShirtDomain findByID = domainRepository.findById(id);
        findByID.inActivate();
        domainRepository.save(findByID);
    }

    @Override
    public void active(Integer id) {
        MeasurementShirtDomain findByID = domainRepository.findById(id);
        findByID.activate();
        domainRepository.save(findByID);
    }
}
