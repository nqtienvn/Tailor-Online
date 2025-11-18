package com.tien.tai.presentation.rest.impl;

import com.tien.common.dto.response.ApiResponse;
import com.tien.common.service.ServiceCommandCommon;
import com.tien.tai.application.dto.request.OrderCreateRequest;
import com.tien.tai.application.dto.response.OrderDTO;
import com.tien.tai.presentation.OrderResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-service/order")
@RequiredArgsConstructor
public class OrderResourceImpl implements OrderResource {
    private final ServiceCommandCommon<OrderDTO, OrderCreateRequest, Integer> orderCommandService;

    @Override
    public ApiResponse<OrderDTO> create(OrderCreateRequest request) {
        return ApiResponse.<OrderDTO>builder()
                .code(200)
                .message("create order item successfully")
                .result(orderCommandService.create(request))
                .build();
    }

    @Override
    public ApiResponse<OrderDTO> update(OrderCreateRequest request, Integer id) {
        return ApiResponse.<OrderDTO>builder()
                .code(200)
                .message("create orderItem successfully")
                .result(orderCommandService.update(request, id))
                .build();
    }

    @Override
    public ApiResponse<OrderDTO> detail(Integer id) {
        return ApiResponse.<OrderDTO>builder()
                .code(200)
                .message("create orderItem successfully")
                .result(orderCommandService.detail(id))
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        orderCommandService.softDelete(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("delete order successfully")
                .build();
    }

    @Override
    public ApiResponse<String> inActive(Integer id) {
        orderCommandService.inActive(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("inactive order successfully")
                .build();
    }

    @Override
    public ApiResponse<String> active(Integer id) {
        orderCommandService.active(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("active order successfully")
                .build();
    }
}
