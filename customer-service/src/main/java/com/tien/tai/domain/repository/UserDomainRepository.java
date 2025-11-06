package com.tien.tai.domain.repository;

import com.tien.tai.domain.model.UserDomain;

public interface UserDomainRepository {
    UserDomain save(UserDomain user);
}
