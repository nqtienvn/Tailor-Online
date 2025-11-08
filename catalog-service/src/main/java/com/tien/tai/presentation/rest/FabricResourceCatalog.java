package com.tien.tai.presentation.rest;

import com.tien.common.controller.catalogservice.ResourceCatalogCommon;
import com.tien.common.dto.response.PagingResponse;
import com.tien.tai.application.dto.request.FabricRequest;
import com.tien.tai.application.dto.request.FabricSearchRequest;
import com.tien.tai.application.dto.response.FabricDTO;
import org.springframework.web.bind.annotation.GetMapping;

public interface FabricResourceCatalog extends ResourceCatalogCommon<FabricDTO, FabricRequest, Integer> {
    @GetMapping("/filter")
    PagingResponse<FabricDTO> search(FabricSearchRequest request);
}
