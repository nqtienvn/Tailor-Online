package com.tien.tai.domain.repository;

import com.tien.tai.domain.model.FabricDomain;

public interface FabricDomainRepository {
    FabricDomain save(FabricDomain fabricDomain);

    FabricDomain findById(Integer id);

    void softDelete(FabricDomain fabricDomain);

    void saveStatus(FabricDomain fabricDomain);
}
