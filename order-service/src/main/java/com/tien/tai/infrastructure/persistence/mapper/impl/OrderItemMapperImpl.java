package com.tien.tai.infrastructure.persistence.mapper.impl;

import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.OrderDomain;
import com.tien.tai.domain.model.OrderItemDomain;
import com.tien.tai.infrastructure.persistence.model.OrderEntity;
import com.tien.tai.infrastructure.persistence.model.OrderItemEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class OrderItemMapperImpl implements ToEntityDomain<OrderItemEntity, OrderItemDomain> {


    @Override
    public OrderItemEntity toEntity(OrderItemDomain domain) {
        return OrderItemEntity.builder()
                .id(domain.getId())
                .productName(domain.getProductName())
                .quantity(domain.getQuantity())
                .price(domain.getPrice())
                .fabricType(domain.getFabricType())
                .orderId(domain.getOrderID())
                .isDeleted(domain.getIsDeleted())
                .status(domain.getStatus())
                .build();
    }

    @Override
    public List<OrderItemDomain> toDomain(List<OrderItemEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return List.of();
        }
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public OrderItemDomain toDomain(OrderItemEntity entity) {
        return OrderItemDomain.builder()
                .id(entity.getId())
                .productName(entity.getProductName())
                .quantity(entity.getQuantity())
                .price(entity.getPrice())
                .fabricType(entity.getFabricType())
                .orderID(entity.getOrderId())
                .isDeleted(entity.getIsDeleted())
                .status(entity.getStatus())
                .build();
    }
}
