package com.tien.tai.application.mapper;

import com.tien.tai.application.dto.request.FabricRequest;
import com.tien.tai.domain.command.FabricCmd;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FabricCommandMapper {
    FabricCmd from(FabricRequest fabricRequest);
}
