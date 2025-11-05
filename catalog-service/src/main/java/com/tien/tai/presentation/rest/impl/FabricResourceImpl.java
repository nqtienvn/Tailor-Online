package com.tien.tai.presentation.rest.impl;

import com.tien.common.dto.response.ApiResponse;
import com.tien.tai.application.dto.request.FabricRequest;
import com.tien.tai.application.dto.response.FabricResponse;
import com.tien.tai.application.service.command.FabricCommandService;
import com.tien.tai.presentation.rest.FabricResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FabricResourceImpl implements FabricResource {
    private final FabricCommandService fabricCommandService;

    @Override
    public ApiResponse<FabricResponse> createFabric(FabricRequest fabricRequest) {
        return ApiResponse.<FabricResponse>builder()
                .code(201)
                .message("add fabric successfully")
                .result(fabricCommandService.create(fabricRequest))
                .build();
    }

    @Override
    public ApiResponse<FabricResponse> updateFabric(FabricRequest fabricRequest, Integer id) {
        return ApiResponse.<FabricResponse>builder()
                .code(200)
                .message("update fabric successfully")
                .result(fabricCommandService.update(fabricRequest, id))
                .build();
    }

    @Override
    public ApiResponse<String> deleteFabric(Integer id) {
        fabricCommandService.softDelete(id);
        return ApiResponse.<String>builder()
                .code(204)
                .message("delete fabric successfully")
                .build();
    }

    @Override
    public ApiResponse<String> inActive(Integer id) {
        fabricCommandService.inActive(id);
        return ApiResponse.<String>builder()
                .code(204)
                .message("in active fabric successfully")
                .build();
    }

    @Override
    public ApiResponse<String> active(Integer id) {
        fabricCommandService.active(id);
        return ApiResponse.<String>builder()
                .code(204)
                .message("active fabric successfully")
                .build();
    }
}
