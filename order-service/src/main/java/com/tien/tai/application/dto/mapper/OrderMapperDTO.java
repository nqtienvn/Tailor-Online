package com.tien.tai.application.dto.mapper;
import com.tien.tai.application.dto.response.OrderDTO;
import com.tien.tai.domain.model.OrderDomain;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapperDTO {
    OrderDTO form (OrderDomain orderDomain);
    List <OrderDTO> toDTO (List <OrderDomain> orders);
}
