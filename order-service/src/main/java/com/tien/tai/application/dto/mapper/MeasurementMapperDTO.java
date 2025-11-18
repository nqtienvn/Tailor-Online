package com.tien.tai.application.dto.mapper;

import com.tien.tai.application.dto.response.MeasurementShirtDTO;
import com.tien.tai.application.dto.response.MeasurementTrouserDTO;
import com.tien.tai.domain.model.MeasurementShirtDomain;
import com.tien.tai.domain.model.MeasurementTrouserDomain;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MeasurementMapperDTO {
    MeasurementShirtDTO from (MeasurementShirtDomain measurementShirtDomain);
    MeasurementTrouserDTO from (MeasurementTrouserDomain measurementTrouserDomain);
    List<MeasurementTrouserDTO> toDTO (List <MeasurementTrouserDomain> measurementTrouserDomain);
}