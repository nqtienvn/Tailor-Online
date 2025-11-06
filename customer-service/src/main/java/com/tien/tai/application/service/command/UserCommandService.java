package com.tien.tai.application.service.command;

import com.tien.tai.application.dto.request.UserRequest;
import com.tien.tai.application.dto.response.UserRespose;
import com.tien.tai.domain.command.UserCmd;
import com.tien.tai.domain.model.UserDomain;

public interface UserCommandService {
    UserRespose create(UserRequest userRequest);
}
