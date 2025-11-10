package com.tien.tai.presentation.rest.impl;

import com.tien.common.dto.response.ApiResponse;
import com.tien.common.dto.response.PageDTO;
import com.tien.common.dto.response.PagingResponse;
import com.tien.common.service.ServiceCatalogCommandCommon;
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
    private final ServiceCatalogCommandCommon<FabricDTO, FabricRequest, Integer> serviceCatalogCommandCommon;
    private final ServiceQueryCommon<PageDTO<FabricDTO>, FabricSearchRequest> serviceQueryCommon;

    @Override

    public ApiResponse<FabricDTO> create(FabricRequest fabricRequest) {
        return ApiResponse.<FabricDTO>builder()
                .code(201)
                .message("add fabric successfully")
                .result(serviceCatalogCommandCommon.create(fabricRequest))
                .build();
    }

    @Override
    public ApiResponse<FabricDTO> update(FabricRequest fabricRequest, Integer id) {
        return ApiResponse.<FabricDTO>builder()
                .code(200)
                .message("update fabric successfully")
                .result(serviceCatalogCommandCommon.update(fabricRequest, id))
                .build();
    }

    @Override
    public ApiResponse<FabricDTO> detail(Integer id) {
        return ApiResponse.<FabricDTO>builder()
                .code(200)
                .message("get fabric successfully")
                .result(serviceCatalogCommandCommon.detail(id))
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        serviceCatalogCommandCommon.softDelete(id);
        return ApiResponse.<String>builder()
                .code(204)
                .message("delete fabric successfully")
                .build();
    }

    @Override
    public ApiResponse<String> inActive(Integer id) {
        serviceCatalogCommandCommon.inActive(id);
        return ApiResponse.<String>builder()
                .code(204)
                .message("in active fabric successfully")
                .build();
    }

    @Override
    public ApiResponse<String> active(Integer id) {
        serviceCatalogCommandCommon.active(id);
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
