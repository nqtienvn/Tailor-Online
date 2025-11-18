package com.tien.tai.presentation;

import com.tien.common.controller.catalogservice.ResourceCatalogCommon;
import com.tien.tai.application.dto.request.OrderItemCreateRequest;
import com.tien.tai.application.dto.response.OrderItemDTO;

public interface OrderItemResource extends ResourceCatalogCommon<OrderItemDTO, OrderItemCreateRequest,Integer> {
}
