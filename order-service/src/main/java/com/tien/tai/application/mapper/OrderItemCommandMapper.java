package com.tien.tai.application.mapper;

import com.tien.tai.application.dto.request.OrderItemRequest;
import com.tien.tai.application.dto.request.OrderRequest;
import com.tien.tai.domain.command.OrderItemCmd;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderItemCommandMapper {
    OrderItemCmd form (OrderItemRequest orderItemRequest);
}
