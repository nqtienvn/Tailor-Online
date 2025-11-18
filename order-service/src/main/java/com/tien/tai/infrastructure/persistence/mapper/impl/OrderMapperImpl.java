package com.tien.tai.infrastructure.persistence.mapper.impl;

import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.OrderDomain;
import com.tien.tai.infrastructure.persistence.model.OrderEntity;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;
@Component
public class OrderMapperImpl implements ToEntityDomain<OrderEntity, OrderDomain> {

    @Override
    public OrderEntity toEntity(OrderDomain domain) {
        return OrderEntity.builder()
                .id(domain.getId())
                .customerName(domain.getCustomerName())
                .status(domain.getStatus())
                .build();
    }

    @Override
    public List<OrderDomain> toDomain(List<OrderEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return List.of();
        }
        return  entities.stream()
                .map(this :: toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDomain toDomain(OrderEntity entity) {
        return OrderDomain.builder()
                .id(entity.getId())
                .customerName(entity.getCustomerName())
                .status(entity.getStatus())
                .build();
    }
}
