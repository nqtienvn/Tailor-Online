package com.tien.tai.presentation.rest.impl;

import com.tien.common.dto.response.ApiResponse;
import com.tien.common.service.ServiceCatalogCommandCommon;
import com.tien.tai.application.dto.request.OrderRequest;
import com.tien.tai.application.dto.response.OrderDTO;
import com.tien.tai.application.dto.response.OrderItemDTO;
import com.tien.tai.presentation.OrderResourceCatalog;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-service/order")
@RequiredArgsConstructor
public class OrderResourceCatalogImpl implements OrderResourceCatalog {
    private final ServiceCatalogCommandCommon<OrderDTO,OrderRequest,Integer> serviceCatalogCommandCommonl;
    @Override
    public ApiResponse<OrderDTO> create(OrderRequest request) {
        return ApiResponse.<OrderDTO>builder()
                .code(200)
                .message("create orderItem successfully")
                .result(serviceCatalogCommandCommonl.create(request))
                .build();
    }

    @Override
    public ApiResponse<OrderDTO> update(OrderRequest request, Integer id) {
        return ApiResponse.<OrderDTO>builder()
                .code(200)
                .message("create orderItem successfully")
                .result(serviceCatalogCommandCommonl.update(request,id))
                .build();
    }

    @Override
    public ApiResponse<OrderDTO> detail(Integer id) {
        return ApiResponse.<OrderDTO>builder()
                .code(200)
                .message("create orderItem successfully")
                .result(serviceCatalogCommandCommonl.detail(id))
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        serviceCatalogCommandCommonl.softDelete(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("delete order successfully")
                .build();
    }

    @Override
    public ApiResponse<String> inActive(Integer id) {
        serviceCatalogCommandCommonl.inActive(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("inactive order successfully")
                .build();
    }

    @Override
    public ApiResponse<String> active(Integer id) {
        serviceCatalogCommandCommonl.active(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("active order successfully")
                .build();
    }
}
