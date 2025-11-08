package com.tien.tai.application.dto.mapper;

import com.tien.tai.application.dto.response.FabricDTO;
import com.tien.tai.domain.model.Fabric;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FabricMapperDTO {
    FabricDTO from(Fabric fabric);

    List<FabricDTO> toDTO(List<Fabric> fabrics);
}
