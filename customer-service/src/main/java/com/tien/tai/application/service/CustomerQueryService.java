package com.tien.tai.application.service;

import com.tien.common.dto.response.PageDTO;
import com.tien.common.service.ServiceQueryCommon;
import com.tien.tai.application.dto.request.CustomerSearchRequest;
import com.tien.tai.application.dto.response.CustomerDTO;

public interface CustomerQueryService extends ServiceQueryCommon<PageDTO<CustomerDTO>, CustomerSearchRequest> {
}
