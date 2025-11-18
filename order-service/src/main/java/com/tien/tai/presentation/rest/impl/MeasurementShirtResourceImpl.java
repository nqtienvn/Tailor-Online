package com.tien.tai.presentation.rest.impl;

import com.tien.common.dto.response.ApiResponse;
import com.tien.tai.application.dto.request.MeasurementShirtRequest;
import com.tien.tai.application.dto.response.MeasurementShirtDTO;
import com.tien.tai.application.service.MeasurementShirtCommandService;
import com.tien.tai.presentation.MeasurementShirtResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-service/measurement-shirt")
@RequiredArgsConstructor
public class MeasurementShirtResourceImpl implements MeasurementShirtResource {
    private final MeasurementShirtCommandService measurementShirtCommandService;

    @Override
    public ApiResponse<MeasurementShirtDTO> create(MeasurementShirtRequest request) {
        return ApiResponse.<MeasurementShirtDTO>builder()
                .code(200)
                .message("creat measurement of shirt successfully")
                .result(measurementShirtCommandService.create(request))
                .build();
    }

    @Override
    public ApiResponse<MeasurementShirtDTO> update(MeasurementShirtRequest request, Integer id) {
        return ApiResponse.<MeasurementShirtDTO>builder()
                .code(200)
                .message("creat measurement of shirt successfully")
                .result(measurementShirtCommandService.update(request, id))
                .build();
    }

    @Override
    public ApiResponse<MeasurementShirtDTO> detail(Integer id) {
        return ApiResponse.<MeasurementShirtDTO>builder()
                .code(200)
                .message("get measurement shirt details success")
                .result(measurementShirtCommandService.detail(id))
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        measurementShirtCommandService.softDelete(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("delete measurement of shirt successfully")
                .build();
    }

    @Override
    public ApiResponse<String> inActive(Integer id) {
        measurementShirtCommandService.inActive(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("inactive measurement of shirt successfully")
                .build();
    }

    @Override
    public ApiResponse<String> active(Integer id) {
        measurementShirtCommandService.active(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("active measurement of shirt successfully")
                .build();
    }
}
