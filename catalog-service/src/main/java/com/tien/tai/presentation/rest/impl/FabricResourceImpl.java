package com.tien.tai.presentation.rest.impl;

import com.tien.common.dto.response.ApiResponse;
import com.tien.common.dto.response.PageDTO;
import com.tien.common.dto.response.PagingResponse;
import com.tien.common.service.ServiceCommandCommon;
import com.tien.common.service.ServiceQueryCommon;
import com.tien.tai.application.dto.request.FabricRequest;
import com.tien.tai.application.dto.request.FabricSearchRequest;
import com.tien.tai.application.dto.response.FabricResponse;
import com.tien.tai.presentation.rest.FabricResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog-service/fabric")
@RequiredArgsConstructor
public class FabricResourceImpl implements FabricResource {
    private final ServiceCommandCommon<FabricResponse, FabricRequest, Integer> serviceCommandCommon;
    private final ServiceQueryCommon<PageDTO<FabricResponse>, FabricSearchRequest> serviceQueryCommon;
    @Override

    public ApiResponse<FabricResponse> create(FabricRequest fabricRequest) {
        return ApiResponse.<FabricResponse>builder()
                .code(201)
                .message("add fabric successfully")
                .result(serviceCommandCommon.create(fabricRequest))
                .build();
    }

    @Override
    public ApiResponse<FabricResponse> update(FabricRequest fabricRequest, Integer id) {
        return ApiResponse.<FabricResponse>builder()
                .code(200)
                .message("update fabric successfully")
                .result(serviceCommandCommon.update(fabricRequest, id))
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        serviceCommandCommon.softDelete(id);
        return ApiResponse.<String>builder()
                .code(204)
                .message("delete fabric successfully")
                .build();
    }

    @Override
    public ApiResponse<String> inActive(Integer id) {
        serviceCommandCommon.inActive(id);
        return ApiResponse.<String>builder()
                .code(204)
                .message("in active fabric successfully")
                .build();
    }

    @Override
    public ApiResponse<String> active(Integer id) {
        serviceCommandCommon.active(id);
        return ApiResponse.<String>builder()
                .code(204)
                .message("active fabric successfully")
                .build();
    }

    @Override
    public PagingResponse<FabricResponse> search(FabricSearchRequest request) {
        return PagingResponse.of(this.serviceQueryCommon.search(request));
    }
}
