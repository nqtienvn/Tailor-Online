package com.tien.tai.application.service;

import com.tien.common.service.ServiceCustomerCommandCommon;
import com.tien.tai.application.dto.request.CustomerCreateRequest;
import com.tien.tai.application.dto.request.CustomerUpdateRequest;
import com.tien.tai.application.dto.response.CustomerDTO;

public interface CustomerCommandService extends ServiceCustomerCommandCommon<CustomerDTO, CustomerCreateRequest, CustomerUpdateRequest, Integer> {
}
