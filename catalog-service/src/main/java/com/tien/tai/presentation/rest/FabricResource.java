package com.tien.tai.presentation.rest;

import com.tien.common.dto.response.ApiResponse;
import com.tien.tai.application.dto.request.FabricRequest;
import com.tien.tai.application.dto.response.FabricResponse;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/catalog-service/fabric")
public interface FabricResource {
    //admin
    @PostMapping()
    ApiResponse<FabricResponse> createFabric(@RequestBody FabricRequest fabricRequest);

    //admin
    @PostMapping("/{id}")
    ApiResponse<FabricResponse> updateFabric(@RequestBody FabricRequest fabricRequest, @PathVariable(name = "id") Integer id);

    //admin
    @DeleteMapping("/{id}")
    ApiResponse<String> deleteFabric(@PathVariable(name = "id") Integer id);

    @PostMapping("/in-active/{id}")
    ApiResponse<String> inActive(@PathVariable(name = "id") Integer id);

    @PostMapping("/active/{id}")
    ApiResponse<String> active(@PathVariable(name = "id") Integer id);

}
