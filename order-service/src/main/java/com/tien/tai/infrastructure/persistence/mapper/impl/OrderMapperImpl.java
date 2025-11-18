package com.tien.tai.infrastructure.persistence.mapper.impl;

import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.OrderDomain;
import com.tien.tai.infrastructure.persistence.model.OrderEntity;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapperImpl implements ToEntityDomain<OrderEntity, OrderDomain> {

    public OrderEntity toEntity(OrderDomain domain) {
        if (domain == null) return null;

        return OrderEntity.builder()
                .id(domain.getId())
                .customerName(domain.getCustomerName())
                .customerPhone(domain.getCustomerPhone())
                .customerAddress(domain.getCustomerAddress())
                .totalAmount(domain.getTotalAmount())
                .depositAmount(domain.getDepositAmount())
                .status(domain.getStatus())
                .build();
    }

    public OrderDomain toDomain(OrderEntity entity) {
        if (entity == null) return null;
        return OrderDomain.builder()
                .id(entity.getId())
                .customerName(entity.getCustomerName())
                .customerPhone(entity.getCustomerPhone())
                .customerAddress(entity.getCustomerAddress())
                .totalAmount(entity.getTotalAmount())
                .depositAmount(entity.getDepositAmount())
                .status(entity.getStatus())
                .build();
    }

    public List<OrderDomain> toDomain(List<OrderEntity> entities) {
        if (entities == null || entities.isEmpty()) return List.of();

        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
}
