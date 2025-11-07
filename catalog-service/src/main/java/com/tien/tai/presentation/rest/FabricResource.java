package com.tien.tai.presentation.rest;

import com.tien.common.controller.catalogservice.ResourceCommon;
import com.tien.common.dto.response.PagingResponse;
import com.tien.tai.application.dto.request.FabricRequest;
import com.tien.tai.application.dto.request.FabricSearchRequest;
import com.tien.tai.application.dto.response.FabricResponse;
import org.springframework.web.bind.annotation.GetMapping;

public interface FabricResource extends ResourceCommon<FabricResponse, FabricRequest, Integer> {
    @GetMapping("/filter")
    PagingResponse<FabricResponse> search(FabricSearchRequest request);
}
