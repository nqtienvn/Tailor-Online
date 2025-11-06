package com.tien.tai.presentation.rest;

import com.tien.common.dto.response.ApiResponse;
import com.tien.tai.application.dto.request.ProductRequest;
import com.tien.tai.application.dto.response.ProductResponse;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/catalog-service/product")
public interface ProductResource {
    //admin
    @PostMapping()
    ApiResponse<ProductResponse> createFabric(@RequestBody ProductRequest productRequest);

    //admin
    @PostMapping("/{id}")
    ApiResponse<ProductResponse> updateFabric(@RequestBody ProductRequest productRequest, @PathVariable(name = "id") Integer id);

    //admin
    @DeleteMapping("/{id}")
    ApiResponse<String> deleteFabric(@PathVariable(name = "id") Integer id);

    @PostMapping("/in-active/{id}")
    ApiResponse<String> inActive(@PathVariable(name = "id") Integer id);

    @PostMapping("/active/{id}")
    ApiResponse<String> active(@PathVariable(name = "id") Integer id);
}
