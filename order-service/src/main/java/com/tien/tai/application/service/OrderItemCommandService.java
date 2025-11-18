package com.tien.tai.application.service;

import com.tien.common.service.ServiceCommandCommon;
import com.tien.tai.application.dto.request.OrderItemCreateRequest;
import com.tien.tai.application.dto.response.OrderItemDTO;

public interface OrderItemCommandService extends ServiceCommandCommon<OrderItemDTO, OrderItemCreateRequest, Integer> {
}
