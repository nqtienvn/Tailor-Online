package com.tien.common.controller.catalogservice;

import com.tien.common.dto.response.ApiResponse;
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
    @PostMapping()
    ApiResponse<T> create(@RequestBody F request);

    //admin
    @PostMapping("/{id}")
    ApiResponse<T> update(@RequestBody F request, @PathVariable(name = "id") I id);

    @GetMapping("/{id}")
    ApiResponse<T> detail(@PathVariable(name = "id") I id);

    //admin
    @DeleteMapping("/{id}")
    ApiResponse<String> delete(@PathVariable(name = "id") I id);

    @PostMapping("/in-active/{id}")
    ApiResponse<String> inActive(@PathVariable(name = "id") I id);

    @PostMapping("/active/{id}")
    ApiResponse<String> active(@PathVariable(name = "id") I id);

}
