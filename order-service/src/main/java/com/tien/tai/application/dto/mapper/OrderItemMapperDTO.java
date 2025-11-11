package com.tien.tai.application.dto.mapper;

import com.tien.tai.application.dto.response.OrderItemDTO;
import com.tien.tai.domain.model.OrderItemDomain;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderItemMapperDTO {
    OrderItemDTO form (OrderItemDomain orderItemDomain);
    List<OrderItemDTO> toDTO (List<OrderItemDTO> orderItemDTOs);
}
