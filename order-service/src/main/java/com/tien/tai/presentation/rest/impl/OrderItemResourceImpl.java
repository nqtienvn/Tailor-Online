package com.tien.tai.presentation.rest.impl;

import com.tien.common.dto.response.ApiResponse;
import com.tien.common.service.ServiceCommandCommon;
import com.tien.tai.application.dto.request.OrderItemCreateRequest;
import com.tien.tai.application.dto.response.OrderItemDTO;
import com.tien.tai.presentation.OrderItemResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-service/orderItem")
@RequiredArgsConstructor
public class OrderItemResourceImpl implements OrderItemResource {
    private final ServiceCommandCommon<OrderItemDTO, OrderItemCreateRequest,Integer> serviceCommandCommon;
    @Override
    public ApiResponse<OrderItemDTO> create(OrderItemCreateRequest request) {
        return ApiResponse.<OrderItemDTO>builder()
                .code(200)
                .message("create orderItem successfully")
                .result(serviceCommandCommon.create(request))
                .build();
    }

    @Override
    public ApiResponse<OrderItemDTO> update(OrderItemCreateRequest request, Integer id) {
        return ApiResponse.<OrderItemDTO>builder()
                .code(200)
                .message("update orderItem successfully")
                .result(serviceCommandCommon.update(request,id))
                .build();
    }

    @Override
    public ApiResponse<OrderItemDTO> detail(Integer id) {
        return ApiResponse.<OrderItemDTO>builder()
                .code(200)
                .message("find orderItem successfully")
                .result(serviceCommandCommon.detail(id))
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        serviceCommandCommon.softDelete(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("delete orderItem successfully")
                .build();
    }

    @Override
    public ApiResponse<String> inActive(Integer id) {
        serviceCommandCommon.inActive(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("inactive orderItem successfully")
                .build();
    }

    @Override
    public ApiResponse<String> active(Integer id) {
        serviceCommandCommon.active(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("active orderItem successfully")
                .build();
    }
}
