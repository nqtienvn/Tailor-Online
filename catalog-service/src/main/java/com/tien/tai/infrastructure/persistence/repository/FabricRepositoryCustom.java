package com.tien.tai.infrastructure.persistence.repository;

import com.tien.tai.domain.query.FabricSearchQuery;
import com.tien.tai.infrastructure.persistence.model.FabricEntity;

import java.util.List;

public interface FabricRepositoryCustom {
    Long count(FabricSearchQuery params);

    List<FabricEntity> search(FabricSearchQuery params);
}
