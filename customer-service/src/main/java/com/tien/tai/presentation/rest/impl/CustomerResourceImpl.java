package com.tien.tai.presentation.rest.impl;

import com.tien.common.dto.response.ApiResponse;
import com.tien.tai.application.dto.request.AddressCreateRequest;
import com.tien.tai.application.dto.request.AddressUpdateRequest;
import com.tien.tai.application.dto.request.CustomerCreateRequest;
import com.tien.tai.application.dto.request.CustomerUpdateRequest;
import com.tien.tai.application.dto.response.AddressDTO;
import com.tien.tai.application.dto.response.CustomerDTO;
import com.tien.tai.application.service.AddressCommandService;
import com.tien.tai.application.service.CustomerCommandService;
import com.tien.tai.presentation.rest.CustomerResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerResourceImpl implements CustomerResource {
    private final CustomerCommandService customerCommandService;
    private final AddressCommandService addressCommandService;

    @Override
    public ApiResponse<CustomerDTO> create(CustomerCreateRequest request) {
        return ApiResponse.<CustomerDTO>builder()
                .code(200)
                .message("Customer created successfully")
                .result(customerCommandService.create(request))
                .build();
    }

    @Override
    public ApiResponse<CustomerDTO> update(CustomerUpdateRequest request, Integer id) {
        return ApiResponse.<CustomerDTO>builder()
                .code(200)
                .message("Update successfully")
                .result(customerCommandService
                        .update(request, id))
                .build();
    }

    @Override
    public ApiResponse<String> inActive(Integer id) {
        customerCommandService.inActive(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("in active successfully")
                .build();
    }

    @Override
    public ApiResponse<String> active(Integer id) {
        customerCommandService.active(id);
        return ApiResponse.<String>builder()
                .code(200)
                .message("active successfully")
                .build();
    }

    @Override
    public ApiResponse<CustomerDTO> detail(Integer id) {
        return ApiResponse.<CustomerDTO>builder()
                .code(200)
                .message("get customers successfully")
                .result(customerCommandService.detail(id))
                .build();
    }

    @Override
    public ApiResponse<List<AddressDTO>> getAddressByCustomerId(Integer id) {
        return ApiResponse.<List<AddressDTO>>builder()
                .code(200)
                .message("get customers successfully")
                .result(addressCommandService.getAddressByCustomerId(id))
                .build();
    }

    @Override
    public ApiResponse<AddressDTO> addNewAddress(AddressCreateRequest addressCreateRequest, Integer id) {
        return ApiResponse.<AddressDTO>builder()
                .code(200)
                .message("create address of customer successfully successfully")
                .result(addressCommandService.addNewAddress(addressCreateRequest, id))
                .build();
    }

    @Override
    public ApiResponse<AddressDTO> update(AddressUpdateRequest addressUpdateRequest, Integer id) {
        return ApiResponse.<AddressDTO>builder()
                .code(200)
                .message("update address of customer successfully successfully")
                .result(addressCommandService.update(addressUpdateRequest, id))
                .build();
    }

    @Override
    public ApiResponse<Boolean> delete(Integer id) {
        return ApiResponse.<Boolean>builder()
                .code(200)
                .message("delete address successfully successfully")
                .result(addressCommandService.delete(id))
                .build();
    }
}