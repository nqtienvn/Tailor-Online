package com.tien.tai.application.service.command.impl;

import com.tien.tai.application.dto.mapper.MeasurementMapperDTO;
import com.tien.tai.application.dto.request.MeasurementTrouserRequest;
import com.tien.tai.application.dto.response.MeasurementTrouserDTO;
import com.tien.tai.application.mapper.MeasurementCommandMapper;
import com.tien.tai.application.service.TrouserCommandService;
import com.tien.tai.domain.command.MeasurementTrouserCmd;
import com.tien.tai.domain.model.MeasurementTrouserDomain;
import com.tien.tai.domain.repository.MeasurementTrouserDomainRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrouserCommandServiceImpl implements TrouserCommandService {
    private final MeasurementCommandMapper commandMapper;
    private final MeasurementMapperDTO mapperDTO;
    private final MeasurementTrouserDomainRepo domainRepository;

    @Override
    public MeasurementTrouserDTO create(MeasurementTrouserRequest request) {
        MeasurementTrouserDomain domain = new MeasurementTrouserDomain(commandMapper.form(request));
        return mapperDTO.from(domainRepository.save(domain));
    }

    @Override
    public MeasurementTrouserDTO update(MeasurementTrouserRequest request, Integer id) {
        MeasurementTrouserCmd measurementCmd = commandMapper.form(request);
        MeasurementTrouserDomain measurementTrouserDomain = domainRepository.findById(id);
        measurementTrouserDomain.update(measurementCmd);
        return mapperDTO.from(domainRepository.save(measurementTrouserDomain));
    }

    @Override
    public MeasurementTrouserDTO detail(Integer id) {
        return mapperDTO.from(domainRepository.findById(id));
    }

    @Override
    public void softDelete(Integer id) {
        MeasurementTrouserDomain findByID = domainRepository.findById(id);
        findByID.softDelete();
        domainRepository.softDelete(findByID);
    }

    @Override
    public void inActive(Integer id) {
        MeasurementTrouserDomain findByID = domainRepository.findById(id);
        findByID.inActivate();
        domainRepository.save(findByID);
    }

    @Override
    public void active(Integer id) {
        MeasurementTrouserDomain findByID = domainRepository.findById(id);
        findByID.activate();
        domainRepository.save(findByID);
    }
}
