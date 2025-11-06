package com.tien.tai.application.dto.mapper;

import com.tien.tai.application.dto.response.FabricResponse;
import com.tien.tai.domain.command.FabricCmd;
import com.tien.tai.domain.model.FabricDomain;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface FabricMapperDTO {
    FabricResponse from(FabricDomain fabricDomain);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFabricFromCmd(FabricCmd fabricCmd, @MappingTarget FabricDomain fabricDomain);
}
