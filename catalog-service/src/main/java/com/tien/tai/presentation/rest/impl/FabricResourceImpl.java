package com.tien.tai.presentation.rest.impl;

import com.tien.common.controller.catalogservice.CatalogResourceCommon;
import com.tien.common.dto.response.ApiResponse;
import com.tien.common.service.catalogservice.CatalogServiceCommand;
import com.tien.tai.application.dto.request.FabricRequest;
import com.tien.tai.application.dto.response.FabricResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog-service/fabric")
@RequiredArgsConstructor
public class FabricResourceImpl implements CatalogResourceCommon<FabricResponse, FabricRequest, Integer> {
    private final CatalogServiceCommand<FabricResponse, FabricRequest, Integer> catalogServiceCommand;

    @Override
    public ApiResponse<FabricResponse> create(FabricRequest fabricRequest) {
        return ApiResponse.<FabricResponse>builder()
                .code(201)
                .message("add fabric successfully")
                .result(catalogServiceCommand.create(fabricRequest))
                .build();
    }

    @Override
    public ApiResponse<FabricResponse> update(FabricRequest fabricRequest, Integer id) {
        return ApiResponse.<FabricResponse>builder()
                .code(200)
                .message("update fabric successfully")
                .result(catalogServiceCommand.update(fabricRequest, id))
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        catalogServiceCommand.softDelete(id);
        return ApiResponse.<String>builder()
                .code(204)
                .message("delete fabric successfully")
                .build();
    }

    @Override
    public ApiResponse<String> inActive(Integer id) {
        catalogServiceCommand.inActive(id);
        return ApiResponse.<String>builder()
                .code(204)
                .message("in active fabric successfully")
                .build();
    }

    @Override
    public ApiResponse<String> active(Integer id) {
        catalogServiceCommand.active(id);
        return ApiResponse.<String>builder()
                .code(204)
                .message("active fabric successfully")
                .build();
    }
}
