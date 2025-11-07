package com.tien.common.controller.catalogservice;

import com.tien.common.dto.response.ApiResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ResourceCommon<T, F, I> {
    //admin
    @PostMapping()
    ApiResponse<T> create(@RequestBody F request);

    //admin
    @PostMapping("/{id}")
    ApiResponse<T> update(@RequestBody F request, @PathVariable(name = "id") I id);

    //admin
    @DeleteMapping("/{id}")
    ApiResponse<String> delete(@PathVariable(name = "id") I id);

    @PostMapping("/in-active/{id}")
    ApiResponse<String> inActive(@PathVariable(name = "id") I id);

    @PostMapping("/active/{id}")
    ApiResponse<String> active(@PathVariable(name = "id") I id);

}
