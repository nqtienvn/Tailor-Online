package com.tien.tai.presentation.rest.impl;

import com.tien.common.dto.response.ApiResponse;
import com.tien.common.service.ServiceCatalogCommandCommon;
import com.tien.tai.application.dto.request.OrderItemRequest;
import com.tien.tai.application.dto.response.OrderItemDTO;
import com.tien.tai.presentation.OrderItemResourceCatalog;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-service/orderItem")
@RequiredArgsConstructor
public class OrderItemResourceCatalogImpl implements OrderItemResourceCatalog {
    private final ServiceCatalogCommandCommon<OrderItemDTO,OrderItemRequest,Integer> serviceCatalogCommandCommon;
    @Override
    public ApiResponse<OrderItemDTO> create(OrderItemRequest request) {
        return ApiResponse.<OrderItemDTO>builder()
                .code(200)
                .message("create orderItem successfully")
                .result(serviceCatalogCommandCommon.create(request))
                .build();
    }

    @Override
    public ApiResponse<OrderItemDTO> update(OrderItemRequest request, Integer id) {
        return ApiResponse.<OrderItemDTO>builder()
                .code(200)
                .message("create orderItem successfully")
                .result(serviceCatalogCommandCommon.update(request,id))
                .build();
    }

    @Override
    public ApiResponse<OrderItemDTO> detail(Integer id) {
        return ApiResponse.<OrderItemDTO>builder()
                .code(200)
                .message("create orderItem successfully")
                .result(serviceCatalogCommandCommon.detail(id))
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        serviceCatalogCommandCommon.softDelete(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("delete orderItem successfully")
                .build();
    }

    @Override
    public ApiResponse<String> inActive(Integer id) {
        serviceCatalogCommandCommon.inActive(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("inactive orderItem successfully")
                .build();
    }

    @Override
    public ApiResponse<String> active(Integer id) {
        serviceCatalogCommandCommon.active(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("active orderItem successfully")
                .build();
    }
}
