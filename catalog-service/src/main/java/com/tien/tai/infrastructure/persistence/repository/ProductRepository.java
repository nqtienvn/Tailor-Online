package com.tien.tai.infrastructure.persistence.repository;

import com.tien.tai.infrastructure.persistence.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCategoryIdIn(List<Integer> categoryIds);
    List<ProductEntity> findByFabricIdIn(List<Integer> fabricIds);

}
