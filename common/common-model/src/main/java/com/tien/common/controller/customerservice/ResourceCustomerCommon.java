package com.tien.common.controller.customerservice;

import com.tien.common.dto.response.ApiResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ResourceCustomerCommon<Tdto, Tcreaterequest, Tupdaterequest, Tid> {
    @PostMapping()
    ApiResponse<Tdto> create(@RequestBody Tcreaterequest request);

    //admin
    @PostMapping("/{id}")
    ApiResponse<Tdto> update(@RequestBody Tupdaterequest request, @PathVariable(name = "id") Tid id);

    //admin
    @PostMapping("/in-active/{id}")
    ApiResponse<String> inActive(@PathVariable(name = "id") Tid id);

    @PostMapping("/active/{id}")
    ApiResponse<String> active(@PathVariable(name = "id") Tid id);

}
