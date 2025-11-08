package com.tien.tai.presentation.rest;

import com.tien.common.controller.customerservice.ResourceCustomerCommon;
import com.tien.tai.application.dto.request.CustomerCreateRequest;
import com.tien.tai.application.dto.request.CustomerUpdateRequest;
import com.tien.tai.application.dto.response.CustomerDTO;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/customer-service")
public interface CustomerResource extends ResourceCustomerCommon<CustomerDTO, CustomerCreateRequest, CustomerUpdateRequest, Integer> {


}
