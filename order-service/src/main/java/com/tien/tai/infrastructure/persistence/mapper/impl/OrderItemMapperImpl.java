package com.tien.tai.infrastructure.persistence.mapper.impl;

import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.OrderItemDomain;
import com.tien.tai.infrastructure.persistence.model.OrderItemEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderItemMapperImpl implements ToEntityDomain<OrderItemEntity, OrderItemDomain> {

    public OrderItemEntity toEntity(OrderItemDomain domain) {
        if (domain == null) return null;

        return OrderItemEntity.builder()
                .id(domain.getId())
                .productId(domain.getProductId())
                .quantity(domain.getQuantity())
                .price(domain.getPrice())
                .orderId(domain.getOrderId())
                .measurementShirtID(domain.getMeasurementShirtID())
                .measurementTrouserID(domain.getMeasurementTrouserID())
                .build();
    }

    public OrderItemDomain toDomain(OrderItemEntity entity) {
        if (entity == null) return null;

        return OrderItemDomain.builder()
                .id(entity.getId())
                .productId(entity.getProductId())
                .quantity(entity.getQuantity())
                .price(entity.getPrice())
                .orderId(entity.getOrderId())
                .measurementShirtID(entity.getMeasurementShirtID())
                .measurementTrouserID(entity.getMeasurementTrouserID())
                .build();
    }

    public List<OrderItemDomain> toDomain(List<OrderItemEntity> entities) {
        if (entities == null || entities.isEmpty()) return List.of();

        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
}
