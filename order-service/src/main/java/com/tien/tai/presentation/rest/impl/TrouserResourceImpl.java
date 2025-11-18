package com.tien.tai.presentation.rest.impl;

import com.tien.common.dto.response.ApiResponse;
import com.tien.tai.application.dto.request.MeasurementTrouserRequest;
import com.tien.tai.application.dto.response.MeasurementTrouserDTO;
import com.tien.tai.application.service.TrouserCommandService;
import com.tien.tai.presentation.MeasurementTrouserResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-service/measurement-trouser")
@RequiredArgsConstructor
public class TrouserResourceImpl implements MeasurementTrouserResource {
    private final TrouserCommandService trouserCommandService;

    @Override
    public ApiResponse<MeasurementTrouserDTO> create(MeasurementTrouserRequest request) {
        return ApiResponse.<MeasurementTrouserDTO>builder()
                .code(200)
                .message("create measurement of trouser successfully")
                .result(trouserCommandService.create(request))
                .build();
    }

    @Override
    public ApiResponse<MeasurementTrouserDTO> update(MeasurementTrouserRequest request, Integer id) {
        return ApiResponse.<MeasurementTrouserDTO>builder()
                .code(200)
                .message("update measurement of trouser successfully")
                .result(trouserCommandService.update(request, id))
                .build();
    }

    @Override
    public ApiResponse<MeasurementTrouserDTO> detail(Integer id) {
        return ApiResponse.<MeasurementTrouserDTO>builder()
                .code(200)
                .message("get measurement trouser details success")
                .result(trouserCommandService.detail(id))
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        trouserCommandService.softDelete(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("delete measurement of trouser successfully")
                .build();
    }

    @Override
    public ApiResponse<String> inActive(Integer id) {
        trouserCommandService.inActive(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("inactive measurement of trouser successfully")
                .build();
    }

    @Override
    public ApiResponse<String> active(Integer id) {
        trouserCommandService.active(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("active measurement of trouser successfully")
                .build();
    }

}
