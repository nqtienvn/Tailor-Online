package com.tien.tai.application.dto.mapper.entitytoresponse;

import com.tien.tai.application.dto.response.OrderItemDTO;
import com.tien.tai.infrastructure.persistence.model.OrderEntity;
import com.tien.tai.infrastructure.persistence.model.OrderItemEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component

public class MapperEntityToResponse {
    public List<OrderItemDTO> toOrderItemDTOs (List <OrderItemEntity> entityList){
        return entityList.stream()
                .map(e -> OrderItemDTO.builder()
                                .id(e.getId())
                                .productId(e.getProductId())
                                .quantity(e.getQuantity())
                                .price(e.getPrice())
                                .build()
                        ).collect(Collectors.toList());
    }
}
