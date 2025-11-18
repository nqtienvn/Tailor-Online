package com.tien.tai.application.mapper;

import com.tien.tai.application.dto.request.MeasurementShirtRequest;
import com.tien.tai.application.dto.request.MeasurementTrouserRequest;
import com.tien.tai.domain.command.MeasurementShirtCmd;
import com.tien.tai.domain.command.MeasurementTrouserCmd;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MeasurementCommandMapper {
    MeasurementShirtCmd form(MeasurementShirtRequest measurementShirtRequest);
    MeasurementTrouserCmd form(MeasurementTrouserRequest measurementTrouserRequest);
}
