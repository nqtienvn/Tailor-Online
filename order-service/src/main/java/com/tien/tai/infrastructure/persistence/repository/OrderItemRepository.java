package com.tien.tai.infrastructure.persistence.repository;


import com.tien.tai.infrastructure.persistence.model.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Integer> {
    List<OrderItemEntity> findByOrderIdIn(List<Integer> orderIds);

}
