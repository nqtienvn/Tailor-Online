package com.tien.tai.infrastructure.persistence.mapper;


import com.tien.tai.domain.model.FabricDomain;
import com.tien.tai.infrastructure.persistence.model.Fabric;

public interface FabricMapper {
    Fabric toEntity(FabricDomain category);

    FabricDomain toDomain(Fabric category);
}
