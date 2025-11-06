package com.tien.tai.application.mapper;

import com.tien.tai.application.dto.request.UserRequest;
import com.tien.tai.domain.command.UserCmd;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserCommandMapper {
    UserCmd from(UserRequest userRequest);
}
