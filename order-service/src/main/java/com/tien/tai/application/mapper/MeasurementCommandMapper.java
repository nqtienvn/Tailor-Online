package com.tien.tai.application.mapper;

import com.tien.tai.application.dto.request.MeasurementRequest;
import com.tien.tai.domain.command.MeasurementCmd;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MeasurementCommandMapper {
    MeasurementCmd form (MeasurementRequest measurementRequest);
}
