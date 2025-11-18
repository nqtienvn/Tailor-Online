package com.tien.tai.presentation;

import com.tien.common.controller.catalogservice.ResourceCatalogCommon;
import com.tien.tai.application.dto.request.OrderCreateRequest;
import com.tien.tai.application.dto.response.OrderDTO;

public interface OrderResource extends ResourceCatalogCommon<OrderDTO, OrderCreateRequest, Integer> {
}
