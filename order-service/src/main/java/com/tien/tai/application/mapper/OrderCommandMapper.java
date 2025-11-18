package com.tien.tai.application.mapper;

import com.tien.tai.application.dto.request.OrderCreateRequest;
import com.tien.tai.domain.command.OrderCmd;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderCommandMapper {
    OrderCmd from (OrderCreateRequest orderCreateRequest);
}
