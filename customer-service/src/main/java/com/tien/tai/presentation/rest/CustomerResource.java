package com.tien.tai.presentation.rest;

import com.tien.common.controller.customerservice.ResourceCustomerCommon;
import com.tien.common.dto.response.ApiResponse;
import com.tien.common.dto.response.PagingResponse;
import com.tien.tai.application.dto.request.*;
import com.tien.tai.application.dto.response.AddressDTO;
import com.tien.tai.application.dto.response.CustomerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customer-service")
public interface CustomerResource extends ResourceCustomerCommon<CustomerDTO, CustomerCreateRequest, CustomerUpdateRequest, Integer> {

    @GetMapping("/{id}/addresses")
    ApiResponse<List<AddressDTO>> getAddressByCustomerId(@PathVariable(name = "id") Integer id);

    @PostMapping("/{id}/addresses")
    ApiResponse<AddressDTO> addNewAddress(@RequestBody AddressCreateRequest addressCreateRequest, @PathVariable(name = "id") Integer id);

    @PostMapping("/addresses/{id}")
    ApiResponse<AddressDTO> update(@RequestBody AddressUpdateRequest addressUpdateRequest, @PathVariable(name = "id") Integer id);

    @DeleteMapping("/addresses/{id}")
    ApiResponse<Boolean> delete(@PathVariable(name = "id") Integer id);

    @GetMapping("/filter")
    PagingResponse<CustomerDTO> search(CustomerSearchRequest request);
}