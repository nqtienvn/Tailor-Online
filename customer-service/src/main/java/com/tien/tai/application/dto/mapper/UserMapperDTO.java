package com.tien.tai.application.dto.mapper;

import com.tien.tai.application.dto.response.UserRespose;
import com.tien.tai.domain.model.UserDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapperDTO {
    UserRespose from(UserDomain user);
}
