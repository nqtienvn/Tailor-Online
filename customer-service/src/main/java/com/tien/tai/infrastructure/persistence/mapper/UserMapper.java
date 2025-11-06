package com.tien.tai.infrastructure.persistence.mapper;

import com.tien.tai.domain.model.UserDomain;
import com.tien.tai.infrastructure.persistence.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDomain user);
    UserDomain toDomain(User user);
}
