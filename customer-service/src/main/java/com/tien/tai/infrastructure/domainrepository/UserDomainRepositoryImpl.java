package com.tien.tai.infrastructure.domainrepository;

import com.tien.tai.domain.model.UserDomain;
import com.tien.tai.domain.repository.UserDomainRepository;
import com.tien.tai.infrastructure.persistence.mapper.UserMapper;
import com.tien.tai.infrastructure.persistence.model.User;
import com.tien.tai.infrastructure.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDomainRepositoryImpl implements UserDomainRepository {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDomain save(UserDomain user) {
        User saveEntity = userRepository.save(userMapper.toEntity(user));
        return userMapper.toDomain(saveEntity);
    }
}
