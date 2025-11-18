package com.tien.tai.application.service;

import com.tien.common.service.ServiceCommandCommon;
import com.tien.tai.application.dto.request.OrderCreateRequest;
import com.tien.tai.application.dto.response.OrderDTO;

public interface OrderCommandService extends ServiceCommandCommon<OrderDTO, OrderCreateRequest, Integer> {
}
