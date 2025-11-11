package com.tien.tai.application.dto.mapper;

import com.tien.tai.application.dto.response.MeasurementDTO;
import com.tien.tai.domain.model.MeasurementDomain;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MeasurementMapperDTO {
    MeasurementDTO from (MeasurementDomain measurementDomain);
    List<MeasurementDTO> toDTO (List <MeasurementDomain> measurementDomains);
}
