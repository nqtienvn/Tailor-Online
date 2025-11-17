package com.tien.tai.infrastructure.persistence.repository;

import com.tien.tai.domain.query.OrderSeachQuery;
import com.tien.tai.infrastructure.persistence.model.OrderEntity;

import java.util.List;

public interface OrderRepositoryCustom {
    Long count (OrderSeachQuery params);
    List<OrderEntity> search (OrderSeachQuery params);
}
