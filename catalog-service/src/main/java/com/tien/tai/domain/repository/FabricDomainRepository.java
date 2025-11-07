package com.tien.tai.domain.repository;

import com.tien.common.domain.repository.DomainRepositoryCommon;
import com.tien.tai.application.dto.response.FabricResponse;
import com.tien.tai.domain.model.Fabric;

import java.util.List;

public interface FabricDomainRepository extends DomainRepositoryCommon<Fabric, Integer> {
    void enrichDTO(List<FabricResponse> fabricDTOS);
}
