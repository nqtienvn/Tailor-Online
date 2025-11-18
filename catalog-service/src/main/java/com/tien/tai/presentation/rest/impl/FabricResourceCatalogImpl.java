package com.tien.tai.presentation.rest.impl;

import com.tien.common.dto.response.ApiResponse;
import com.tien.common.dto.response.PageDTO;
import com.tien.common.dto.response.PagingResponse;
import com.tien.common.service.ServiceCommandCommon;
import com.tien.common.service.ServiceQueryCommon;
import com.tien.tai.application.dto.request.FabricRequest;
import com.tien.tai.application.dto.request.FabricSearchRequest;
import com.tien.tai.application.dto.response.FabricDTO;
import com.tien.tai.presentation.rest.FabricResourceCatalog;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog-service/fabric")
@RequiredArgsConstructor
public class FabricResourceCatalogImpl implements FabricResourceCatalog {
    private final ServiceCommandCommon<FabricDTO, FabricRequest, Integer> serviceCommandCommon;
    private final ServiceQueryCommon<PageDTO<FabricDTO>, FabricSearchRequest> serviceQueryCommon;

    @Override

    public ApiResponse<FabricDTO> create(FabricRequest fabricRequest) {
        return ApiResponse.<FabricDTO>builder()
                .code(201)
                .message("add fabric successfully")
                .result(serviceCommandCommon.create(fabricRequest))
                .build();
    }

    @Override
    public ApiResponse<FabricDTO> update(FabricRequest fabricRequest, Integer id) {
        return ApiResponse.<FabricDTO>builder()
                .code(200)
                .message("update fabric successfully")
                .result(serviceCommandCommon.update(fabricRequest, id))
                .build();
    }

    @Override
    public ApiResponse<FabricDTO> detail(Integer id) {
        return ApiResponse.<FabricDTO>builder()
                .code(200)
                .message("get fabric successfully")
                .result(serviceCommandCommon.detail(id))
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
    public PagingResponse<FabricDTO> search(FabricSearchRequest request) {
        return PagingResponse.of(this.serviceQueryCommon.search(request));
    }
}
