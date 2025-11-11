package com.tien.tai.presentation.rest.impl;

import com.tien.common.dto.response.ApiResponse;
import com.tien.common.service.ServiceCatalogCommandCommon;
import com.tien.tai.application.dto.request.MeasurementRequest;
import com.tien.tai.application.dto.response.MeasurementDTO;
import com.tien.tai.presentation.MeasurementResourceCatalog;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-service/measurement")
@RequiredArgsConstructor
public class MeasurementResourceCatalogImpl implements MeasurementResourceCatalog {
    private final ServiceCatalogCommandCommon<MeasurementDTO,MeasurementRequest,Integer> serviceCatalogCommandCommon;

    @Override
    public ApiResponse<MeasurementDTO> create(MeasurementRequest request) {
        return ApiResponse.<MeasurementDTO>builder()
                .code(200)
                .message("creat measurement successfully")
                .result(serviceCatalogCommandCommon.create(request))
                .build();

//        return ApiResponse.<CategoryDTO>builder()
//                .code(200)
//                .message("create category successfully")
//                .result(serviceCatalogCommandCommon.create(categoryRequest))
//                .build();
    }

    @Override
    public ApiResponse<MeasurementDTO> update(MeasurementRequest request, Integer id) {
        return ApiResponse.<MeasurementDTO>builder()
                .code(200)
                .message("creat measurement successfully")
                .result(serviceCatalogCommandCommon.update(request,id))
                .build();
    }

    @Override
    public ApiResponse<MeasurementDTO> detail(Integer id) {
        return ApiResponse.<MeasurementDTO>builder()
                .code(200)
                .message("creat measurement successfully")
                .result(serviceCatalogCommandCommon.detail(id))
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        serviceCatalogCommandCommon.softDelete(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("delete category successfully")
                .build();

//        serviceCatalogCommandCommon.softDelete(id);
//        return ApiResponse.<String>builder()
//                .code(200)
//                .message("delete category successfully")
//                .build();
    }

    @Override
    public ApiResponse<String> inActive(Integer id) {
        serviceCatalogCommandCommon.inActive(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("inactive category successfully")
                .build();
    }

    @Override
    public ApiResponse<String> active(Integer id) {
        serviceCatalogCommandCommon.active(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("active category successfully")
                .build();
    }
}
