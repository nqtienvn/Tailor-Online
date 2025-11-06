package com.tien.tai.presentation.rest.impl;

import com.tien.common.dto.response.ApiResponse;
import com.tien.tai.application.dto.request.UserRequest;
import com.tien.tai.application.dto.response.UserRespose;
import com.tien.tai.application.service.command.UserCommandService;
import com.tien.tai.presentation.rest.CustomerResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerResourceImpl implements CustomerResource {

    private final UserCommandService userCommandService;

    public ApiResponse<UserRespose> createUser(@RequestBody UserRequest userRequest){
        return ApiResponse.<UserRespose>builder()
                .code(200)
                .message("create user successfully")
                .result(userCommandService.create(userRequest))
                .build();
    }
    public ApiResponse<UserRespose> updateUser(@RequestBody UserRequest userRequest){
        return null;
    }
    public ApiResponse<UserRespose> deleteUser(@RequestBody UserRequest userRequest){
        return null;
    }
}
