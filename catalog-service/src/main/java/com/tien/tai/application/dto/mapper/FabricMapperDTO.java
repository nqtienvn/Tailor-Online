package com.tien.tai.application.dto.mapper;

import com.tien.tai.application.dto.response.FabricResponse;
import com.tien.tai.domain.model.Fabric;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FabricMapperDTO {
    FabricResponse from(Fabric fabric);
}
