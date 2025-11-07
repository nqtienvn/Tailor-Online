package com.tien.tai.infrastructure.persistence.repository;

import com.tien.tai.infrastructure.persistence.model.FabricEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricRepository extends JpaRepository<FabricEntity, Integer> {
}
