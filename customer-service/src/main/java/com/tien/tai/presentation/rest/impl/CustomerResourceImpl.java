package com.tien.tai.presentation.rest.impl;

import com.tien.common.dto.response.ApiResponse;
import com.tien.tai.application.dto.request.CustomerCreateRequest;
import com.tien.tai.application.dto.request.CustomerUpdateRequest;
import com.tien.tai.application.dto.response.CustomerDTO;
import com.tien.tai.application.service.CustomerCommandService;
import com.tien.tai.presentation.rest.CustomerResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerResourceImpl implements CustomerResource {
    private final CustomerCommandService customerCommandService;

    @Override
    public ApiResponse<CustomerDTO> create(CustomerCreateRequest request) {
        return ApiResponse.<CustomerDTO>builder().code(200).message("Customer created successfully").result(customerCommandService.create(request)).build();
    }

    @Override
    public ApiResponse<CustomerDTO> update(CustomerUpdateRequest request, Integer id) {
        return ApiResponse.<CustomerDTO>builder().code(200).message("Update successfully").result(customerCommandService.update(request, id)).build();
    }

    @Override
    public ApiResponse<String> inActive(Integer id) {
        customerCommandService.inActive(id);
        return ApiResponse.<String>builder().code(200).message("in active successfully").build();
    }

    @Override
    public ApiResponse<String> active(Integer id) {
        customerCommandService.active(id);
        return ApiResponse.<String>builder().code(200).message("active successfully").build();
    }
}