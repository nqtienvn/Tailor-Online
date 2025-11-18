package com.tien.common.controller.catalogservice;

import com.tien.common.dto.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
/**
 * Generic interface for managing catalog-type resources.
 * Provides CRUD and status management endpoints (active/inactive/delete).
 *
 * @param <T> Response DTO type
 * @param <F> Request DTO type
 * @param <I> Identifier type (e.g. Long, Integer)
 */
public interface ResourceCatalogCommon<T, F, I> {
    //admin
    @Operation(summary = "create object")
    @PostMapping()
    ApiResponse<T> create(@RequestBody F request);

    //admin
    @Operation(summary = "Update object by Id")
    @PostMapping("/{id}")
    ApiResponse<T> update(@RequestBody F request, @PathVariable(name = "id") I id);
    @Operation(summary = "Detail object")
    @GetMapping("/{id}")
    ApiResponse<T> detail(@PathVariable(name = "id") I id);

    //admin
    @Operation(summary = "delete Object")
    @DeleteMapping("/{id}")
    ApiResponse<String> delete(@PathVariable(name = "id") I id);
    @Operation(summary = "Inactive object")
    @PostMapping("/in-active/{id}")
    ApiResponse<String> inActive(@PathVariable(name = "id") I id);

    @PostMapping("/active/{id}")
    @Operation(summary = "Inactive object")
    ApiResponse<String> active(@PathVariable(name = "id") I id);

}
