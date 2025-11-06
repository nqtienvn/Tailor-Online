package com.tien.tai.presentation.rest;

import com.tien.common.dto.response.ApiResponse;
import com.tien.tai.application.dto.request.UserRequest;
import com.tien.tai.application.dto.response.UserRespose;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/customer-service")
public interface CustomerResource {

    @PostMapping("/user")
    ApiResponse<UserRespose> createUser(@RequestBody UserRequest userRequest);

    @PutMapping("/update")
    ApiResponse<UserRespose> updateUser(@RequestBody UserRequest userRequest);

    @DeleteMapping("/{id}")
    ApiResponse<UserRespose> deleteUser(@RequestBody UserRequest userRequest);
}
