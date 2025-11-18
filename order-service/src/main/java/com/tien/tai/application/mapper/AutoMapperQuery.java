package com.tien.tai.application.mapper;

import com.tien.tai.application.dto.request.*;
import com.tien.tai.domain.query.MeasurementSearchQuery;
import com.tien.tai.domain.query.OrderItemSearchQuery;
import com.tien.tai.domain.query.OrderSeachQuery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AutoMapperQuery {
    OrderSeachQuery form (OrderSearchRequest request);
    OrderItemSearchQuery form (OrderItemSearchRequest request);
    MeasurementSearchQuery form (MeasurementSearchRequest request);

}
