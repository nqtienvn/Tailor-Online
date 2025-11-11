package com.tien.tai.presentation;

import com.tien.common.controller.catalogservice.ResourceCatalogCommon;
import com.tien.tai.application.dto.request.MeasurementRequest;
import com.tien.tai.application.dto.response.MeasurementDTO;
import com.tien.tai.domain.command.MeasurementCmd;

public interface MeasurementResourceCatalog extends ResourceCatalogCommon <MeasurementDTO , MeasurementRequest,Integer> {
}
